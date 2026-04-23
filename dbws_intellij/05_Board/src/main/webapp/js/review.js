$(function() {
    // boby가 다 로드 되면 실행하는 곳.
    // searchReviews();
    showAllreview();

});

function showAllreview() {
    $("#search-btn").click(function (){
        const reviewTitle =  $("#search-input").val();
        console.log(reviewTitle);

        $.ajax({
            url : 'review-search', // 어디로 요청?, review-search?title=? 이런 식으로!
            data : {reviewTitle} // data의 정체는 파라미터
            // 너(JS): "review-search야, reviewTitle='피자' 이거 줄게"
        }).done(function(resData){
            console.log(resData);

            showResult(resData);
        }).fail(function(xhr, status, error) {
            console.log(status);
            console.log(error);
        })

    })
}




function searchReviews(){


    $.ajax({
        url : 'review-search', // 어디로 요청?, review-search?title=? 이런 식으로!
        data : {reviewTitle} // data의 정체는 파라미터
        // 너(JS): "review-search야, reviewTitle='피자' 이거 줄게"
    }).done(function(resData){
        console.log(resData);

        showResult(resData);
    }).fail(function(xhr, status, error) {
        console.log(status);
        console.log(error);
    })


}

function showResult(resData){
    $("#result").empty();
    $.each(resData, function(i, r){
        console.log(i);
        console.log(r);
        // 백틱을 왜 자유롭게 쓸 수 있지?
        let content = `<div class="review-row">
                    <div>
                        <span onclick="location.href='review-detail?pk=${r.no}', this">${r.title }</span>
                    </div>
                    <div>${r.date } <button onclick="del('${r.no}')">del</button></div>
                </div>`

        $("#result").append(content);
    })
    //비동기가 무조건 좋은 게 아님
    // 설문조사를 한다면? 뒤로 가기를 눌렀을 때 직전 페이지로 가는 게 아니라
    // 아예 첫페이지로 이동해버림!
    // 그래서 때에 따라서 적절하게 사용해야함
}

function del(no,btn){

    console.log(no)
    $.ajax({
        url: 'review-del',    // 어디로 요청?
        data: {no} // data : 파라미터
    }).done(function (resData) {
        console.log(resData);
        if (resData == 1){
            //1. 전체로드
            //showAllreview()
            //2. 지워진 그거만 삭제
            //$(btn).parent().parent().remove();
            $(btn).closest('.review-row').remove();
        }
    })

}