function pushPlus() {
    const money = document.getElementById("money");
    let cnt = document.getElementById("cnt");
    let totalMoney = document.getElementById("totalMoney");
    cnt.value = Number(cnt.value) + 1;
    totalMoney.innerText = Number(money.textContent) * Number(cnt.value);
}

function pushMinus() {
    const money = document.getElementById("money");
    let cnt = document.getElementById("cnt");
    let totalMoney = document.getElementById("totalMoney");
    cnt.value = Number(cnt.value) - 1;
    totalMoney.innerText = Number(money.textContent) * Number(cnt.value);
}