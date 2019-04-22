
function insertToDb() {
    var http = new XMLHttpRequest();
    var url = 'http://localhost:8080/word/addWord';
    var input = document.getElementById("insert").value;

    http.open('POST', url, true);
    http.setRequestHeader('Content-type', 'application/json');

    http.onreadystatechange = function() {//Call a function when the state changes.
    if(http.readyState == 4 && http.status == 200) {
//        alert(http.responseText);
        }
    }

    if (!input == ""){
        http.send(input);
        document.getElementById("insert").value="";
    }else {
//        alert("not a word")
        document.getElementById("error").style.display="block";
        setTimeout(function(){
                     document.getElementById('error').style.display = "none";
                     },3000);
    }
}

function matchWord() {
    var ul = document.getElementById("dynamic-list");
    var http = new XMLHttpRequest();
    var wordToMatch = document.getElementById("match").value;
    var url = `http://localhost:8080/word/match?wordtomatch=${wordToMatch}`;

    http.open('GET', url, true);
    http.setRequestHeader('Content-type', 'application/json');
    http.onreadystatechange = function() {//Call a function when the state changes.
    if(http.readyState == 4 && http.status == 200) {
    txt = http.responseText;
    var data = JSON.parse(txt);

    if (data===null){
        alert("try again, not enough words in the list")
        document.getElementById("match").value="";
        return;
    }
    var ul = document.getElementById("dynamic-list-match");
    if(ul){
            if(ul.childElementCount > 0){
              ul.innerHTML='';
            }
        }

    for(var i=0; i<data.length; i++){
          var li = document.createElement("li");
          li.setAttribute('id',data[i].word);

          if(i==0){
            li.appendChild(document.createTextNode("The word to match is : " + document.getElementById("match").value + ""));
            li.appendChild(document.createTextNode("The ascii value is : " + mAsciiValue()));
            var mybr = document.createElement('br');
            li.appendChild(mybr);
            document.getElementById("match").value="";
            }
          li.appendChild(document.createTextNode("id : " + data[i].id + " "));
          li.appendChild(document.createTextNode("The word is : " + data[i].word + "---"));
          li.appendChild(document.createTextNode("The ascii value is : " + data[i].asciiValue + "---"));
          li.appendChild(document.createTextNode("The difference is : " + data[i].difference));
          ul.appendChild(li);
        }
      }
    }

    if (!wordToMatch == ""){
            http.send();
        }else {
            document.getElementById("errorMatch").style.display="block";
            setTimeout(function(){
                     document.getElementById('errorMatch').style.display = "none";
                     },3000);
              }
}

  function getMyWords() {
    var http = new XMLHttpRequest();
    var url = 'http://localhost:8080/word/getMyWords';
    var txt ;

    http.open('GET', url, true);
    http.setRequestHeader('Content-type', 'application/json');

    http.onreadystatechange = function() {//Call a function when the state changes.
    if(http.readyState == 4 && http.status == 200) {
    txt = http.responseText;
    var data = JSON.parse(txt);

    var ul = document.getElementById("dynamic-list");

    if(ul){
        if(ul.childElementCount > 0){
          ul.innerHTML='';
        }
    }

    for(var i=0; i<data.length; i++){
          var li = document.createElement("li");
          li.setAttribute('id',data[i].word);
          li.appendChild(document.createTextNode("id : " + data[i].id + "---"));
          li.appendChild(document.createTextNode("The word is : " + data[i].word + "---"));
          li.appendChild(document.createTextNode("The ascii value is : " + data[i].asciiValue));
          ul.appendChild(li);
        }
      }
    }
  http.send();
}

function mAsciiValue(){
    var input = document.getElementById("match").value;
    var sum = 0 ;
    for (var i = 0; i < input.length; i++) {
      sum = sum + parseInt(input.charCodeAt(i),10)
    }

    return sum;
}

function deleteError(){
     document.getElementById('error').style.display = "none";
}

function check(value) {

    switch(value)
       {
           case "1":
                alert("1")
                break;
           case "2":
                alert("2")
                break;
           case "3":
                alert("3")
                break;

           default: alert("default");
       }
}

function moveToPage(){
    window.location.href = "www.google.com";
}


