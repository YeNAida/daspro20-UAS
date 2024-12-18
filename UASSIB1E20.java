import java.util.Scanner;

public class UASSIB1E20 {
    static String[][] tabelSkor_20 = new String[100][4];
    static int jumlahData_20 = 0; 
    static Scanner input_20 = new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut_20 = true; 
        while (lanjut_20) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. INPUT DATA SKOR TIM ");
            System.out.println("2. TAMPILKAN TABEL SKOR ");
            System.out.println("3. TENTUKAN JUARA ");
            System.out.println("4. KELUAR ");
            System.out.print("PILIH MENU (1-4): ");
            int menu_20 = input_20.nextInt();
            input_20.nextLine();

            switch (menu_20) {
                case 1:
                    inputData_20();
                    break;
                case 2:
                    tampilkanTabelSkor_20();
                    break;
                case 3:
                    tentukanJuara_20();
                    break;
                case 4:
                    System.out.println("TERIMA KASIH! ");
                    lanjut_20 = false;
                    break;
                default:
                    System.out.println("PILIHAN TIDAK VALID, SILAHKAN MENCOBA KEMBALI!");
                    break;
            }
        }
    }

    public static void inputData_20() {
        while (true) {
            System.out.println("\nMASUKKAN DATA TIM");
            System.out.print("Nama Tim: ");
            String namaTim_20 = input_20.nextLine();

            System.out.print("Masukkan skor untuk Level 1: ");
            int skorLevel1_20 = input_20.nextInt();
            if (skorLevel1_20 <= 35) skorLevel1_20 = 0;

            System.out.print("Masukkan skor untuk Level 2: ");
            int skorLevel2_20 = input_20.nextInt();
            if (skorLevel2_20 <= 35) skorLevel2_20 = 0;
            input_20.nextLine();

            int totalSkor_20 = skorLevel1_20 + skorLevel2_20;

            if (totalSkor_20 % 2 == 0) {
                totalSkor_20 -= 15;
            }

            if (skorLevel2_20 > 50) {
                totalSkor_20 += 20;
            }

            tabelSkor_20[jumlahData_20][0] = namaTim_20;
            tabelSkor_20[jumlahData_20][1] = String.valueOf(skorLevel1_20);
            tabelSkor_20[jumlahData_20][2] = String.valueOf(skorLevel2_20);
            tabelSkor_20[jumlahData_20][3] = String.valueOf(totalSkor_20);

            jumlahData_20++;

            System.out.print("Tambah tim lain? (y/t): ");
            String pilihan_20 = input_20.nextLine();
            if (pilihan_20.equalsIgnoreCase("t")) break;
        }
    }

    public static void tampilkanTabelSkor_20() {
        if (jumlahData_20 == 0) {
            System.out.println("Data belum diinput. Pilih menu terlebih dahulu.");
            return;
        }

        System.out.println("\n=== TABEL SKOR TURNAMEN ===");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
        for (int i_20 = 0; i_20 < jumlahData_20; i_20++) {
            System.out.printf("%-15s %-10s %-10s %-10s\n", tabelSkor_20[i_20][0], tabelSkor_20[i_20][1], tabelSkor_20[i_20][2], tabelSkor_20[i_20][3]);
        }
    }

    public static void tentukanJuara_20() {
        if (jumlahData_20 == 0) {
            System.out.println("Data belum diinput. Pilih menu terlebih dahulu.");
            return;
        }

        int skorTertinggi_20 = Integer.parseInt(tabelSkor_20[0][3]);
        String juara_20 = tabelSkor_20[0][0];
        int skorLevel2Tertinggi_20 = Integer.parseInt(tabelSkor_20[0][2]);

        boolean seri_20 = false;

        for (int i_20 = 1; i_20 < jumlahData_20; i_20++) {
            int totalSkor_20 = Integer.parseInt(tabelSkor_20[i_20][3]);
            int skorLevel2_20 = Integer.parseInt(tabelSkor_20[i_20][2]);

            if (totalSkor_20 > skorTertinggi_20) {
                skorTertinggi_20 = totalSkor_20;
                juara_20 = tabelSkor_20[i_20][0];
                skorLevel2Tertinggi_20 = skorLevel2_20;
                seri_20 = false;
            } else if (totalSkor_20 == skorTertinggi_20) {
                if (skorLevel2_20 > skorLevel2Tertinggi_20) {
                    juara_20 = tabelSkor_20[i_20][0];
                    skorLevel2Tertinggi_20 = skorLevel2_20;
                    seri_20 = false;
                } else if (skorLevel2_20 == skorLevel2Tertinggi_20) {
                    seri_20 = true;
                }
            }
        }

        if (seri_20) {
            System.out.println("\nTurnamen berakhir seri. Tim terbaik adalah Yola.");
        } else {
            System.out.println("\nSelamat kepada tim " + juara_20 + " yang telah memenangkan kompetisi dengan skor " + skorTertinggi_20 + "!");
        }
    }
}
