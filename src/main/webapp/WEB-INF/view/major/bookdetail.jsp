<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>금오공과대학교 도서구매 시스템</title>
    <script type="text/javascript" src="../../../static/major.js"></script>
    <link href="../../../static/major.css" rel="stylesheet" type="text/css">
    <style>
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

        #selectGrade, #selectLecture, #search {
            height: 2.5rem;
        }
        header {
            display: none;
            padding: 1rem;
        }

    </style>
</head>
<body>
<jsp:include page= "../layout/header.jsp"/>
<!-- 컨텐츠 -->
<section class = "mainSection">
    <div class = "mainContainer">
        <div class = "mainInfoContainer">
            <div id = "standard">
                <h1>컴퓨터소프트웨어공학과</h1>
                <select id = "selectGrade">
                    <option selected>학년</option>
                    <option>1학년</option>
                    <option>2학년</option>
                    <option>3학년</option>
                    <option>4학년</option>
                </select>
                <select id="selectLecture" onchange="myFunction()">
                    <option selected>과목</option>
                    <option>웹프로그래밍</option>
                    <option>객체지향소프트웨어공학</option>
                    <option>컴퓨터그래픽스</option>
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
                <button id = "purchaseBtn" onclick="doPay()">구매하기</button>
                <button id = "myCart" onclick="doSave()">장바구니</button>
            </div>
        </div>
    </div>
</section>
<script>
    const line = document.getElementById("line");
    if(matchMedia("(min-width: 768px)").matches) {
        line.style.visibility = "hidden";
    } else {
        line.style.visibility = "visible";
    }

    function doPay() {
        let flag = confirm("결제하시겠습니까?");
        if(flag)
            alert("결제되었습니다.");
        else
            alert("결제가 취소되었습니다.");
    }

    function doSave() {
        let flag = confirm("장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?");
    }

    function myFunction(){
        // 루트 찾기, 행 만들어 주기
        const root = document.getElementsByTagName('ul')[1];
        var li = document.createElement("li");

        // div 만들어 주기
        var imgDiv = document.createElement("img");
        imgDiv.className = "image";
        imgDiv.setAttribute("src", "../../../img/oose.jpg");
        imgDiv.setAttribute("width", "100%");

        var infoDiv = document.createElement("div");
        infoDiv.className = "info";

        var nameDiv = document.createElement("div");
        nameDiv.innerHTML = "<strong>소프트웨어 공학 에센셜</strong>"
        nameDiv.className = "name";
        var makerDiv = document.createElement("div");
        makerDiv.className = "maker";
        makerDiv.style.display = "block";
        makerDiv.innerHTML = "<div id = \"author\">윤청</div> 저 | <div id = \"publishing\">생능출판</div>";

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
        totalMoney.innerText = 33000;

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
        li.setAttribute('money', totalMoney.innerText);
        // 리스트에 추가
        root.appendChild(li);

        plusbtn.addEventListener("click", function() {
            cnt.value = Number(cnt.value) + 1;
            totalMoney.innerText = 33000 * Number(cnt.value);
            li.setAttribute("money", 33000 * Number(cnt.value));

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
            totalMoney.innerText = 33000 * Number(cnt.value);
            li.setAttribute('money', 33000 * Number(cnt.value));
            var liArr =  document.getElementById("mySelections").getElementsByTagName("li");
            var sum = 0;
            for(var i = 0; i < liArr.length; i++) {
                sum += Number(liArr[i].getAttribute("money"));
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
</body>
</html>
