const taskInput = document.getElementById('taskInput');
const addTaskButton = document.getElementById('addTaskButton');
const taskList = document.getElementById('taskList');
const dueDateInput = document.getElementById('dueDate');

let tasks = JSON.parse(localStorage.getItem('tasks')) || [];   
let currentFilter = "all";


function renderTasks(){
    taskList.innerHTML = '';
    let filteredTasks = tasks;
    if(currentFilter === "completed"){
        // .filter() returns only matching items.
        filteredTasks = tasks.filter(task => task.completed);
    } else if(currentFilter === "pending"){
        filteredTasks = tasks.filter(task => !task.completed);
    }
    filteredTasks.forEach(task=>{
        const li = document.createElement('li');
        li.draggable = true;
        li.dataset.id = task.id;
        if(task.completed){
            li.classList.add('completed');
        }
        li.innerHTML = `
        ${task.text}
        <small>Due: ${task.dueDate || "No due date"}</small>
        <button onclick="deleteTask(${task.id})">Delete</button>
        <button onclick="toggleCompleted(${task.id})">Done</button>
        <button onclick="editTask(${task.id})">Edit</button>    
        `;
        taskList.appendChild(li);
    })
    enableDragDrop();
}

function deleteTask(id){
    //removes task with matching id
    tasks = tasks.filter(task => task.id !== id);
    saveTasks();
    renderTasks();
}

function toggleCompleted(id){
    //finds task by ID
    const task = tasks.find(t=>t.id===id);
    task.completed = !task.completed;
    saveTasks();
    renderTasks();
}
function setFilter(filter){
    currentFilter=filter;
    renderTasks();
}
function editTask(id){
    const newText = prompt("Edit task:");
    if(!newText) return;
    const task = tasks.find(t=>t.id===id);
    task.text = newText;
    saveTasks();
    renderTasks();
}

addTaskButton.addEventListener("click", () => {
    const taskText = taskInput.value.trim();
    const duedate = dueDateInput.value;
    if(taskText){
        tasks.push({ 
            id: Date.now(),
            text: taskText,
            dueDate: duedate,
            completed: false
        });
        taskInput.value = '';
        dueDateInput.value = '';
        saveTasks();
        renderTasks();
    }else{
        alert("Please enter a task");
        return;
    }
});
function saveTasks(){
    localStorage.setItem('tasks', JSON.stringify(tasks));
}
renderTasks();