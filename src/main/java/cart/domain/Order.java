package cart.domain;

import cart.exception.OrderException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {
    private final Long id;
    private final Member member;
    private final List<OrderItem> orderItems;
    private final Point usedPoint;
    private final Point savedPoint;
    private final LocalDateTime orderedAt;

    public Order(Long id, Member member, List<OrderItem> orderItems, Point usedPoint, Point savedPoint,
                 LocalDateTime orderedAt) {
        this.id = id;
        this.member = member;
        this.orderItems = orderItems;
        this.usedPoint = usedPoint;
        this.savedPoint = savedPoint;
        this.orderedAt = orderedAt;
    }

    public Order(Member member, List<OrderItem> orderItems, Point usedPoint, Point savedPoint) {
        this(null, member, orderItems, usedPoint, savedPoint, LocalDateTime.now());
    }

    public void checkOwner(Member member) {
        if (!Objects.equals(this.member.getId(), member.getId())) {
            throw new OrderException.IllegalMember(this, member);
        }
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Point getUsedPoint() {
        return usedPoint;
    }

    public Point getSavedPoint() {
        return savedPoint;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }
}
