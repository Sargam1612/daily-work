<template>
  <h2>Add User</h2>

  <input v-model="name" placeholder="Name" />
  <input v-model="email" placeholder="Email" />
  <label><input type="radio" name="gender" value="Male" v-model="gender">Male</label>
  <label><input type="radio" name="gender" value="Female" v-model="gender">Female</label>
<br/>
  <input type="checkbox" v-model="subjects" value="Math">Math <br/>
  <input type="checkbox" v-model="subjects" value="Science">Science <br/>
  <input type="checkbox" v-model="subjects" value="History">History <br/>
  <button @click="saveUser">Save</button>

</template>

<script>
import api from '../services/api'

export default {
  data() {
    return {
      name: '',
      email: '',
      gender:'',
      subjects: []
    }
  },
  methods: {
    saveUser() {
      api.addUser({
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
