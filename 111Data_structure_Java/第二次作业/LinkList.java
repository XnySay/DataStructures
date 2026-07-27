//public class LinkList {
//	// 头结点
//	private  Node head;
//	// 链表的长度
//	private  int size;
//
//	// 构造函数初始化头结点，也可以在插入第一个节点的时候初始化
//	LinkList(){
//		head = new Node();
//	}
//	// 头插法
//	public void insertFromHead(int data){
//		// 将data封装为Node节点
//		Node node = new Node(data);
//		// 如果链表为空,直接跟在head后面
//		if(head.next == null){
//			head.next = node;
//			size++;
//		}else{
//			// 链表不为空，头插法插入节点
//			node.next = head.next;
//			head.next = node;
//			size++;
//		}
//	}
//	// 尾插法
//	public void insertFromLast(int data) {
//		Node node = new Node(data);
//		if (head.next == null) {
//			head.next = node;
//			size++;
//		} else {
//			// 这里要注意的是，while的判断是current.next是否为空
//			// 意思 就是current最后肯定是指向链表的最后一个节点
//			Node current = head.next;
//			while (current.next != null) {
//				current = current.next;
//			}
//			// 直接跟到最后
//			current.next = node;
//			// 长度+1
//			size++;
//		}
//	}
//	// 获取链表长度
//	public int getSize(){
//		return size;
//	}
//	// 删除节点
//	public void remove(int data) {
//		if (head.next == null){
//			System.out.println("当前链表为空");
//			return;
//		}
//		Node current = head;
//		while (current.next != null) {
//			if(current.next.data == data){
////				current.next = current.next.next;
//				Node removeNode = current.next;
//				current.next = removeNode.next;
//				removeNode = null;//help GC
//				size--;
//				return;
//			}else{
//				current = current.next;
//			}
//		}
//		if(current.next == null){
//			System.out.println("该链表中没有这个节点");
//		}
//	}
//	// 删除指定下标的节点
//	public void removeIndex(int index){
//		if(index < 0 || index > size){
//			System.out.println("请输入正确的下标");
//			return;
//		}
//		if (head.next == null){
//			System.out.println("当前链表为空");
//			return;
//		}
//		int startIndex = 1;
//		Node current = head;
//		while(current.next != null && startIndex < index){
//			current = current.next;
//			startIndex++;
//		}
//		// 删除节点
//		Node removeNode = current.next;
//		current.next = removeNode.next;
//		removeNode = null;//help GC
//		size--;
//	}
//	// 遍历链表
//	public void printNode() {
//		if (head.next == null) {
//			System.out.println("链表为空!");
//			return;
//		}
//		Node current = head.next;
//		while (current.next != null) {
//			System.out.print(current.data + "--->");
//			current = current.next;
//		}
//		System.out.println(current.data);
//		System.out.println("链表长度为："+size);
//	}
//
//	//逆置算法,利用头插法
//	public void inversion(){
//		if(head.next==null||head.next.next==null){
//			return;
//		}
//		Node s=null;
//		Node p=head.next;
//		head.next=null;
//		while(p!=null){
//			s=p;
//			p=p.next;
//			s.next=head.next;
//			head.next=s;
//		}
//	}
//
//	//逆置算法，利用三指针
//	public void inversion2(){
//		if(head.next==null||head.next.next==null){
//			return;
//		}
//		Node pre=null;
//		Node s=null;
//		Node p=head.next;
//		while(p!=null){
//			s=p;
//			p=p.next;
//			s.next=pre;
//			pre.next=s;
//		}
//		head.next=pre;
//	}
//}