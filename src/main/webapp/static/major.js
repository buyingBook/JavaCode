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

