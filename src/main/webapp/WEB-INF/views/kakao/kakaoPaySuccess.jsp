<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
</head>
<body>
    결제 성공
    결제일시 : ${info.approved_at}</br>
    주문번호 : ${info.partner_order_id}</br>
    상품명 : ${info.item_name}</br>
    상품수량 : ${info.quantity}</br>
    결제금액 : ${info.amount.total}</br>
    결제방법 : ${info.payment_method_type}
    <div id="hidden" style="display: none;">
        <p id="cid">cid : ${info.cid}</p>
        <p id="tid">tid : ${info.tid}</p>
        <p id="cancel_tax">cancel_tax_free_amount : ${info.tax_free_amount}</p>
    </div>
    <form method="post" action="/kakao/kakaoPayCancel" id="cancelForm">
        <button id="cancel">결제 취소</button>
    </form>
</body>
    <script type="text/javascript" src="/js/kakaoPayCancel.js"></script>
</html>