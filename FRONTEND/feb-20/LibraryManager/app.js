const API = "http://localhost:3000/books";
const list = document.getElementById("bookList");

async function loadBooks(){
 let res = await fetch(API);
 let books = await res.json();
 render(books);
}

//sends data to UI builder
function render(books){
 list.innerHTML="";
 books.forEach(b=>{
  let li=document.createElement("li");
  li.textContent=`${b.title} - ${b.author}`;
  li.className=b.available?"available":"issued";

  let issue=document.createElement("button");
  issue.textContent=b.available?"Issue":"Return";
  issue.onclick=()=>toggleBook(b);

  let del=document.createElement("button");
  del.textContent="Delete";
  del.onclick=()=>deleteBook(b.id);

  li.append(issue,del);
  list.appendChild(li);
 });
}

async function addBook(){
 let title=document.getElementById("title").value;
 let author=document.getElementById("author").value;
 if(!title||!author) return;

 await fetch(API,{method:"POST",
 headers:{"Content-Type":"application/json"},
 body:JSON.stringify({title,author,available:true})});
 loadBooks();
}

async function toggleBook(book){
 await fetch(API+"/"+book.id,{method:"PATCH",
 headers:{"Content-Type":"application/json"},
 body:JSON.stringify({available:!book.available})});
 loadBooks();
}

async function deleteBook(id){
 await fetch(API+"/"+id,{method:"DELETE"});
 loadBooks();
}

addBtn.onclick=addBook;
loadBooks();


search.oninput=async()=>{
    let res=await fetch(API);
    let books=await res.json();
    let term=search.value.toLowerCase();
    render(books.filter(b=>b.title.toLowerCase().includes(term)));
};
