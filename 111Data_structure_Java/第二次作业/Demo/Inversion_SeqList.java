package Demo;

class InversionSeqList{
	// 头结点
	private  Node head;
	// 链表的长度
	private  int size;

    //逆置算法,利用头插法
	public void inversion1(){
		if(head.next==null||head.next.next==null){
			return;
		}
		Node s=null;
		Node p=head.next;
		head.next=null;
		while(p!=null){
			s=p;
			p=p.next;
			s.next=head.next;
			head.next=s;
		}
	}

	//逆置算法，利用三指针
	public void inversion2() {
        if (head.next == null || head.next.next == null) {
            return;
        }
        Node pre = null;
        Node s = null;
        Node p = head.next;
        while (p != null) {
            s = p;
            p = p.next;
            s.next = pre;
            pre.next = s;
        }
        head.next = pre;
    }
}
