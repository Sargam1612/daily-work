const taskInput = document.getElementById('taskInput');
const addTaskButton = document.getElementById('addTaskButton');
const taskList = document.getElementById('taskList');

let tasks = JSON.parse(localStorage.getItem('tasks')) || [];    
function renderTasks(){
    taskList.innerHTML = '';
    tasks.forEach((task, index) => {
        const li = document.createElement('li');
        li.textContent = task.text;
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', (e) => {
            e.stopPropagation();    
            tasks.splice(index, 1);
            saveTasks();
            renderTasks();
        });
        li.appendChild(deleteButton);
        taskList.appendChild(li);
    });
}
addTaskButton.addEventListener('click', () => {
    const taskText = taskInput.value.trim();
    if(taskText){
        tasks.push({ text: taskText });
        saveTasks();
        renderTasks();
        taskInput.value = '';
    }
});
function saveTasks(){
    localStorage.setItem('tasks', JSON.stringify(tasks));
}
renderTasks();