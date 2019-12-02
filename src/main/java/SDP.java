import java.util.Arrays;
import java.util.Random;

public class SDP  {

//    public static Vertex SDP(Vertex p, int data) {
//        while (p != null) {
//            if (data < p.getData()) {
//                if (p.getLeft() != null)
//                    p = p.getLeft();
//                else
//                    p.setLeft(new Vertex(data));
//            } else {
//                if (data > p.getData()) {
//                    if (p.getRight() != null)
//                        p = p.getRight();
//                    else
//                        p.setRight(new Vertex(data));
//                } else
//                    break;
//            }
//        }
//        if (p == null) {
//            p = new Vertex(data);
//        }
//        return p;
//    }
//
//
//    public static Vertex SDP2(Vertex p, int data) {
//        if (p == null) {
//            p = new Vertex(data);
//            return p;
//        } else {
//            if (data < p.getData())
//                p.setLeft(SDP2(p.getLeft(), data));
//            else {
//                if (data > p.getData())
//                    p.setRight(SDP2(p.getRight(), data));
//            }
//            return p;
//        }
//    }
//
//    public static void main(String[] args) {
//        final int n = 100;
//        Tree tree = new Tree();
//
//        boolean b = true;
//
//        Vertex root = null;
//        Random random = new Random();
//
//        int[] m = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            while (b) {
//                int x = random.nextInt(150);
//                for (int j = 0; j < i; j++) {
//                    if (x == m[j]) {
//                        b = false;
//                        break;
//                    }
//                }
//                if (b) {
//                    m[i] = x;
//                    break;
//                }
//                b = true;
//            }
//
//        }
//
//		BTree bTree = new BTree();
//		System.out.println("\nDBD obhod: ");
//		for (int i = 0; i < n; i++) {
//			bTree.root = bTree.insert(m[i], bTree.root);
//		}
//		tree.Obhod1(bTree.root);
//
//
//        AVL avl = new AVL();
//        for (int i = 0; i < n; i++) {
//            avl.root = avl.insert(avl.root, m[i]);
//        }
//        System.out.println("\nОбход АВЛ: ");
//        tree.Obhod1(avl.root);
//
//        root = SDP(root, m[0]);
//
//        for (int i = 1; i < n; i++) {
//            SDP(root, m[i]);
//        }
//        System.out.println("\nSDP 1 Obhod 1: ");
//        Obhod1(root);
//        System.out.println();
//
//        root = SDP2(root, m[0]);
//        for (int i = 1; i < n; i++) {
//            SDP2(root, m[i]);
//        }
//
//        System.out.println("SDP 2 Obhod2: ");
//        Obhod1(root);
//        System.out.println();
//
//        System.out.println("\nISDP obhod: ");
//        Arrays.sort(m);
//        Vertex rootISPD = tree.CreateISPD(0, n - 1, m);
//        tree.Obhod1(rootISPD);
//
//
//
//
//        double h_middle_ISPD = (double) tree.Sumlength(rootISPD, 1) / (double) tree.Size(rootISPD);
//        double h_middle_SDP = (double) tree.Sumlength(root, 1) / (double) tree.Size(root);
//        double h_middleAVL = (double) tree.Sumlength(avl.root, 1) / (double) tree.Size(avl.root);
//		double h_middleBTree = (double) tree.Sumlength(bTree.root, 1) / (double) tree.Size(bTree.root);
//
//
//        System.out.println("\n\n n = " + n + " | Размер | Контр.Сумма | Высота | Средняя высота |");
//        System.out.println("----------------------------------------------------------|");
//        System.out.println("   ИСДП  |  " + tree.Size(rootISPD) + "   |     " + tree.Sum(rootISPD) + "    |    "
//                + tree.Height(rootISPD) + "   |       " + h_middle_ISPD + "      |");
//        System.out.println("----------------------------------------------------------|");
//        System.out.println("    СДП  |  " + tree.Size(root) + "   |     " + tree.Sum(root) + "    |   "
//                + tree.Height(root) + "   |       " + h_middle_SDP + "     |");
//        System.out.println("----------------------------------------------------------|");
//        System.out.println("    АВЛ  |  " + tree.Size(avl.root) + "   |     " + tree.Sum(avl.root) + "    |   "
//                + tree.Height(avl.root) + "   |       " + h_middleAVL + "     |");
//		System.out.println("----------------------------------------------------------|");
//		System.out.println("    ДБД  |  " + tree.Size(bTree.root) + "   |     " + tree.Sum(bTree.root) + "    |   "
//				+ tree.Height(bTree.root) + "   |       " + h_middleBTree + "     |");
//
//
//        System.out.println("\nКолличество уровней в ДБД: " + tree.Depth(bTree.root, 0));
//        System.out.println("\nКолличество уровней в ИСДП: " + tree.Depth(rootISPD, 0));
//
//
///////////////////////////////////////////////////////////////////////////
//// Удаление из AVL
////        Scanner scanner = new Scanner(System.in);
////
////        System.out.println("\n\nУдаление:");
////        avl.root = null;
////
////        for (int i = 0; i < 10; i++) {
////            int x = random.nextInt(15);
////            avl.root = avl.insert(avl.root, x);
////        }
////        System.out.println("\nОбход Авл: ");
////
////
////        while (avl.root != null) {
////            tree.Obhod1(avl.root);
////            System.out.println("\nЧто удалить ?: ");
////            avl.root = avl.delete(avl.root, scanner.nextInt());
////        }
////        System.out.println("Avl Пуст");
//
//
//    }
}
