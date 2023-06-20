const tabItem = document.querySelectorAll(".tab-container__item");
const tabContent = document.querySelectorAll(".content-container__content");

tabItem.forEach((item) => {
    item.addEventListener("click", tabHandler);
});

function tabHandler(item) {
    const tabTarget = item.currentTarget;
    const target = tabTarget.dataset.tab;
    tabItem.forEach((title) => {
        title.classList.remove("active");
    });
    tabContent.forEach((target) => {
        target.classList.remove("target");
    });
    document.querySelector("#" + target).classList.add("target");
    tabTarget.classList.add("active");
}

function sendPost(id) {
    let hiddenForm = document.createElement('form');
    let obj;
    obj = document.createElement('input')
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'id');
    obj.setAttribute('value', id);

    hiddenForm.appendChild(obj);
    hiddenForm.setAttribute('method', 'post');
    hiddenForm.setAttribute('action', '/product');
    document.body.appendChild(hiddenForm);
    hiddenForm.submit();
}