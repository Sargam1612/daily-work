<template>
  <h2>Edit User</h2>

  <input v-model="name" />
  <input v-model="email" />
  <label><input type="radio" name="gender" value="Male" v-model="gender">Male</label>
  <label><input type="radio" name="gender" value="Female" v-model="gender"> Female</label>
  <input type="checkbox" v-model="subjects" value="Math">Math
  <input type="checkbox" v-model="subjects" value="Science">Science
  <input type="checkbox" v-model="subjects" value="History">History 
  <button @click="updateUser">Update</button>
</template>

<script>
import api from '../services/api'

export default {
  data() {
    return {
      name: '',
      email: '',
      gender: ''
    }
  },
  mounted() {
    const id = this.$route.params.id
    api.getUser(id).then(res => {
      this.name = res.data.name
      this.email = res.data.email
      this.gender = res.data.gender
      this.subjects = res.data.subjects || []
    })
  },
  methods: {
    updateUser() {
      const id = this.$route.params.id
      api.updateUser(id, {
        name: this.name,
        email: this.email,
        gender: this.gender,
        subjects: this.subjects
      }).then(() => {
        this.$router.push('/users')
      })
    }
  }
}
</script>
