const API = "http://localhost:3000/books";
const bookList = document.getElementById("bookList");


loadBooks(){
    let res = fetch(API);
    let books = res.json();
    render(books);
    //.json() converts it into a JavaScript array
}
/sends data to UI builder
function render(books){
    await bookList.innerHTML = "";
