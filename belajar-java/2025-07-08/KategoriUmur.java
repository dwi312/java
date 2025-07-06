public class KategoriUmur {
    public static void main(String[] args) {
        int umur = 17;

        if(umur < 12) {
            System.out.println("Anak-anak");
        } else if (umur < 18) {
            System.out.println("Remaja");
        } else if (umur < 60) {
            System.out.println("Dewasa");
        } else {
            System.out.println("Lansia");
        }
    }

}
