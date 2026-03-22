public interface SoldierVisitor {
    void visit(SoldierGroup group);

    void visit(Infantryman infantryman);

    void visit(Horseman horseman);

    void visit(ProxySoldier proxySoldier);
}
