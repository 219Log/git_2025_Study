package calss1.ex;

public class ProductOderMain {

    public static void main(String[] args) {
        //여러상품의 주문 정보를 담는 배열 생성
        ProductOrder order1 = new ProductOrder();
        order1.productName = "두부";
        order1.price = 2000;
        order1.quantity = 2;

        ProductOrder order2 = new ProductOrder();
        order2.productName = "김치";
        order2.price = 5000;
        order2.quantity = 1;


        ProductOrder order3 = new ProductOrder();
        order3.productName = "꿀";
        order3.price = 10330;
        order3.quantity = 12;

        //상품 주문 정보를 'ProductOrder' 타입의 변수로 받아 저장
        ProductOrder[] productOrder =  {order1,order2,order3};


        //상품 주문 정보와 최종 금액 출력
        int totalPrice = 0;
        for (ProductOrder po : productOrder) {
            System.out.println("상품명 : " +  po.productName + "금액 : " + po.price + "수량 : " + po.quantity);
            totalPrice += po.price * po.quantity;
        }

        System.out.println("총 결제 금액 : " + totalPrice);
    }
}
