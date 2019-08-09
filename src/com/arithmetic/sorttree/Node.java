package com.arithmetic.sorttree;

/**
 * @Author WYMY
 * @Date 2019/4/28 22:08
 */
public class Node {
    int value;
    Node left;
    Node right;
    //如果节点重复count+1 没有重复count=0
    int count = 0;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (null == node) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        } else {
            this.count++;
        }
        //右旋转
        if (this.leftHigh() - this.rightHigh() >= 2) {
            if (this.left != null && this.left.leftHigh() - this.left.rightHigh() < 0) {
                //双旋转
                leftRotate(this.left);
                rightRotate(this);
            } else {
                //单旋转
                rightRotate(this);
            }
            //左旋转
        } else if (this.rightHigh() - this.leftHigh() >= 2) {
            if (this.right != null && this.right.leftHigh() - this.right.rightHigh() > 0) {
                //双旋转
                rightRotate(this.right);
                leftRotate(this);
            } else {
                //单旋转
                leftRotate(this);
            }
        }
    }

    //左旋转
    private void leftRotate(Node node) {
        //使新节点等于当前节点
        Node newNode = new Node(node.value);
        newNode.count = node.count;
        //将新节点的左节点设置为当前节点的左节点
        newNode.left = node.left;
        //将新节点的右节点设置为当前节点的右节点的左节点
        newNode.right = node.right.left;
        //使当前节点的右节点取代当前节点
        this.value = this.right.value;
        this.count = this.right.count;
        //把新节点的右子树设置为原来右节点的右子树
        this.right = this.right.right;
        //把当前节点的左子树设置为新节点
        this.left = newNode;
    }

    //右旋转
    private void rightRotate(Node node) {
        //使新节点等于当前节点
        Node newNode = new Node(node.value);
        newNode.count = node.count;
        //将新节点的右节点设置为当前节点的右节点
        newNode.right = node.right;
        //将新节点的左节点设置为当前节点的左节点的右节点
        newNode.left = node.left.right;
        //使当前节点的左节点取代当前节点
        this.value = this.left.value;
        this.count = this.left.count;
        //把新节点的左子树设置为原来左节点的左子树
        this.left = this.left.left;
        //把当前节点的右子树设置为新节点
        this.right = newNode;
    }

    //返回左子树深度
    public int leftHigh() {
        if (this.left == null) {
            return 0;
        }
        return this.left.high();
    }

    //返回右子树深度
    public int rightHigh() {
        if (this.right == null) {
            return 0;
        }
        return this.right.high();
    }

    public int high() {
        return Math.max(this.left == null ? 0 : this.left.high(), this.right == null ? 0 : this.right.high()) + 1;
    }

    public Node search(int value) {

        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查询父节点方法1
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }

    }

    //查询父节点方法2
    public Node searchP(int value) {
        if (this.value > value) {
            Node newNode = this.left;
            if (newNode == null) {
                return null;
            }
            if (newNode.value == value) {
                return this;
            } else {
                return newNode.searchP(value);
            }
        } else {
            Node newNode = this.right;
            if (newNode == null) {
                return null;
            }
            if (newNode.value == value) {
                return this;
            } else {
                return newNode.searchP(value);
            }
        }
    }
}

