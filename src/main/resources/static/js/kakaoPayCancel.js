var IMP = window.IMP; 
IMP.init("imp11225448"); 

$("cancel").click(function() {
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
            var msg = '결제가 취소되었습니다.';
            
            // console.log(rsp);
            // $('#kakaoForm').submit();
        } else {
            var msg = '결제취소에 실패하였습니다';
            // console.log(rsp);
        }
        alert(msg);
    });
})