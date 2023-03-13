var pay = document.getElementById("card_pay");
var IMP = window.IMP; 
IMP.init("imp11225448"); 

pay.addEventListener("click",function() {

    IMP.request_pay({
        pg : 'kakaopay',
        pay_method : 'card',
        merchant_uid: 'Kakao_'+new Date().getTime(), 
        name : '당근 10kg',
        amount : 100,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : 'sugang',
        buyer_tel : '010-1234-5678',
        buyer_addr : '경기도 수원시',
        buyer_postcode : '123-456'
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
});

$("#kakaoPay").click(function(){
    IMP.request_pay({
        pg : 'kakaopay',
        pay_method : 'card',
        merchant_uid: 'Kakao_'+new Date().getTime(), 
        name : '당근 10kg',
        amount : 100,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : 'sugang',
        buyer_tel : '010-1234-5678',
        buyer_addr : '경기도 수원시',
        buyer_postcode : '123-456'
    }, function (rsp) { // callback
        if (rsp.success) {
            var msg = '결제가 완료되었습니다';
            msg+= '결제금액 : ' + rsp.paid_amount;
            // console.log(rsp);
            // $('#kakaoForm').submit();
        } else {
            var msg = '결제에 실패하였습니다';
            msg += '에러내용 : ' + rsp.error_msg;
            // console.log(rsp);
        }
        alert(msg);
    });
})