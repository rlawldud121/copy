$(function () {
    // main
    getJSON();

});

function getJSON() {

    // jQuery
    $("#json-btn").click(function (){
        $.ajax({
            url : 'get-json' //목적지가 있어야 어디로 갈지 정할 수 있음
            //data : 우측에다 파라미터값을 넘길 수 있음  => sql을 떠올려라!(기능)
        }).done(function(resData) {
            console.log(resData); // 위에 함수가 다 돌면 나오는 값을 resData라고 내가 임의로 이름을 붙임, 여기엔 배열이 담겼음!
            let content = "";
            $.each(resData, function (i, p){ // i는 인덱스 번호, p는 인덱스에 해당하는 값
                // 배열은 반복문을 써야 안의 내용을 꺼낼 수 있음
                content += `<div>${p.name} / ${p.age}</div>`;
            })
            $(".result").append(content);
        })

    });
    //$("#json-btn").click( () =>{

    //});

    //아래 2개는 바닐라 자바스크립트
    //document.querySelector("#json-btn").addEventListener("click", function () {

    //})
    //document.querySelector("#json-btn").addEventListener("click", ()=>{

    //})

}