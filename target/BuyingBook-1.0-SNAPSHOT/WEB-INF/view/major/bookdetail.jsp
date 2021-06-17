<%@ page import="domain.Book" %>
<%@ page import="persistence.BookRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <script type="text/javascript" src="../../../static/major.js"></script>
    <link href="../../../static/major.css" rel="stylesheet" type="text/css">
    <style>
        #standard h1 {
            text-align: center;
        }

        #totalPrice h1 {
            display: inline;
        }
        li {
            list-style-type: none;
            display: flex;
            flex-direction: row;
        }

        .image {
            margin-right: 1rem;
        }
        .info {
            padding-top: 2rem;
        }
        .price {
            background-color: teal;
        }
        #bookImg {
            margin-left: 2.5rem;
        }
        .choice input {
            text-align: right;
            width: 3rem;
            height: 1rem;
            font-size: 16px;
            font-family: 'Nanum Gothic', 'serif';
        }

        #control form button {
            display: inline;
            width: 45%;
            height: 2.5rem;
            color: white;
            background-color: #0099ff;
            font-family: 'Nanum Gothic', 'serif';
            font-size: 20px;
            margin: 1%;
        }
        #selectGrade, #selectLecture, #search {
            height: 2.5rem;
        }
        header {
            display: none;
            padding: 1rem;
        }

    </style>
    <script>
        let myChoice = [];
        let count = -1;
        function getMyChoice() {
            return myChoice;
        }
        function myFunction() {
            const target = document.getElementById("selectLecture");
            const lid = target.options[target.selectedIndex].value;
            console.log('target', target, 'asdf: ', lid);
            sessionStorage.setItem("lid", lid);
            console.log(sessionStorage.getItem("bookList"));
            console.log('lid is ', sessionStorage.getItem("lid"));

            // 루트 찾기, 행 만들어 주기
            const root = document.getElementById("mySelections");
            const li = document.createElement("li");

            // div 만들어 주기
            var imgDiv = document.createElement("img");
            imgDiv.className = "image";
            imgDiv.setAttribute("width", "100%");
            var infoDiv = document.createElement("div");
            infoDiv.className = "info";
            var nameDiv = document.createElement("div");
            nameDiv.className = "name";
            var makerDiv = document.createElement("div");
            makerDiv.className = "maker";
            makerDiv.style.display = "block";
            var choiceDiv = document.createElement("div");
            choiceDiv.className = "choice";
            var plusbtn = document.createElement('button');
            plusbtn.id = "plusbtn";
            plusbtn.innerText = '+';
            var minusbtn = document.createElement('button');
            minusbtn.id = "minusbtn";
            minusbtn.innerText = '-';
            var cancelbtn = document.createElement('button');
            cancelbtn.id = "cancelbtn";
            cancelbtn.innerText = 'X';
            var cnt = document.createElement('input');
            cnt.id = "cnt";
            cnt.value = 1;
            var totalMoney = document.createElement('p');
            totalMoney.id = "totalMoney";

            console.log(sessionStorage)

            var booklist =[]
            <c:forEach items="${books}" var="book">
            var book = {
                'bookNum': "${book.bookNum}",
                'bookName': "${book.bookName}",
                'bookAuthor': "${book.bookAuthor}",
                'bookPub': "${book.bookPub}",
                'bookPrice': "${book.bookPrice}",
                'imageURL': "${book.imageURL}",
                'cnt': 1
            };
            booklist.push(book);
            </c:forEach>

            myChoice.push(booklist[lid-1]);
            count++;
            imgDiv.setAttribute("src", booklist[lid-1].imageURL);
            nameDiv.innerHTML = "<strong>" + booklist[lid-1].bookName + "</strong>"
            makerDiv.innerHTML = "<div id = \"author\">" + booklist[lid-1].bookAuthor +
                "</div> 저 | <div id = \"publishing\">" + booklist[lid-1].bookPub + "</div>";
            totalMoney.innerText = booklist[lid-1].bookPrice;


            choiceDiv.insertAdjacentElement('beforeend', cnt);
            choiceDiv.insertAdjacentElement('beforeend', minusbtn);
            choiceDiv.insertAdjacentElement('beforeend', plusbtn);
            choiceDiv.insertAdjacentElement('beforeend', cancelbtn);
            choiceDiv.insertAdjacentElement('beforeend', totalMoney);

            infoDiv.insertAdjacentElement('beforeend', nameDiv);
            infoDiv.insertAdjacentElement('beforeend', makerDiv);
            infoDiv.insertAdjacentElement('beforeend', choiceDiv);

            li.insertAdjacentElement('beforeend', imgDiv);
            li.insertAdjacentElement('beforeend', infoDiv);
            li.setAttribute('money', booklist[lid-1].bookPrice);
            li.id = booklist[lid-1].bookNum;


            // 리스트에 추가
            root.appendChild(li);

            plusbtn.addEventListener("click", function() {
                cnt.value = Number(cnt.value) + 1;
                myChoice[count].cnt++;
                totalMoney.innerText = booklist[lid-1].bookPrice * Number(cnt.value);
                li.setAttribute("money", booklist[lid-1].bookPrice * Number(cnt.value));

                var liArr = document.getElementById("mySelections").getElementsByTagName("li");
                var sum = 0;
                for(var i = 0; i < liArr.length; i++) {
                    sum += Number(liArr[i].getAttribute("money"));
                }
                var amount = document.getElementById('amount');
                amount.innerText = sum;
            }, false);



            minusbtn.addEventListener("click", function() {
                cnt.value = Number(cnt.value) - 1;
                myChoice[count].cnt--;
                totalMoney.innerText = booklist[lid-1].bookPrice * Number(cnt.value);
                li.setAttribute('money', booklist[lid-1].bookPrice * Number(cnt.value));
                var liArr =  document.getElementById("mySelections").getElementsByTagName("li");
                var sum = 0;
                for(var i = 0; i < liArr.length; i++) {
                    sum += Number(liArr[i].getAttribute("money"))
                }
                var amount = document.getElementById('amount');
                amount.innerText = sum;
            }, false);


            cancelbtn.addEventListener("click", function() {
                li.remove();

                setComboToSelectOption('selectLecture', 's');

                var liArr =  document.getElementById("mySelections").getElementsByTagName("li");
                var sum = 0;
                for(var i = 0; i < liArr.length; i++) {
                    sum += Number(liArr[i].getAttribute("money"));
                }

                var amount = document.getElementById('amount');
                amount.innerText = sum;
            }, false);

            var liArr =  document.getElementById("mySelections").getElementsByTagName("li");
            var sum = 0;
            for(var i = 0; i < liArr.length; i++) {
                sum += Number(liArr[i].getAttribute("money"));
            }

            var amount = document.getElementById('amount');
            amount.innerText = sum;
        }
    </script>
</head>
<jsp:include page= "../layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainSection">
    <div class = "mainContainer">
        <div class = "mainInfoContainer">
            <div id = "standard">
                <h1>${target.majorName}</h1>
                <select id="selectLecture" name="lid" onchange="myFunction()">
                        <option>과목</option>
                        <c:forEach var="lecture" items="${lectures}">
                            <option value="${lecture.lectureNum}">${lecture.lectureName}</option>
                        </c:forEach>
                </select>

            </div>
            <ul id = "mySelections" class="mySelections">
            </ul>
        </div>

        <div><hr visibility="visible"></div>
        <div class = "subInfoContainer">
            <div id = "totalPrice" style="display: inline">
                <h1>총 가격: </h1>
                <h1><div id = "amount">0</div></h1>
                <h1>원</h1>
            </div>
            <div id = "control">
                <form id = "sendPayQuery" action="pay">
<%--                    <input type="hidden" name="bid" value="1">--%>
<%--                    <input type="hidden" name="cnt" value="1">--%>
                    <button id = "purchaseBtn" name="state" value="1" onclick="doPay()">구매하기</button>
                    <button id = "myCart" name="state" value="0" onclick="doSave()">장바구니</button>
                </form>
            </div>
        </div>
    </div>
</section>

<script>
    function doPay() {
        let flag = confirm("결제하시겠습니까?");
        if(flag) {
            alert("결제되었습니다.");
        }
        else
            alert("결제가 취소되었습니다.");
    }

    function doSave() {
        let flag = alert("장바구니에 담겼습니다.");
        // var root = document.getElementById("sendPayQuery");
        // for(var i = 0; i < myChoice.length; i++) {
        //     var bookIdInput = document.createElement("input");
        //     bookIdInput.setAttribute("name", "bid" + i);
        //     bookIdInput.setAttribute("value", myChoice[i].bookNum);
        //     var cntInput = document.createElement("input");
        //     cntInput.setAttribute("name", "cnt" + i);
        //     cntInput.setAttribute("value", myChoice[i].cnt);
        //     root.append(bookIdInput, cntInput);
        // }
    }

    function setComboToSelectOption(_comboId, _itemId) {
        var comboObj = document.getElementById(_comboId);
        if (comboObj == null) {
            return false;
        }

        if (comboObj.options == null || comboObj.options.length == 0) {
           return false;
        }

        if (_itemId == null) {
            _itemId = "";
        }

        var optionCount = comboObj.options.length;
        for (var i=0; i<optionCount; i++) {
            if (comboObj.options[i].id == _itemId) {
                comboObj.options[i].selected = true;
                return true;
            }
        }
        return false;
    }
</>
</body>
</html>
