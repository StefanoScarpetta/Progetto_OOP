import Classi.Gestione;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Progetto {

    public static void main(String[] args) throws IOException {

        File file = new File("progetto/StandardInput/StandardInput.txt");
        Scanner in = new Scanner(file);
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
        Gestione gestione = new Gestione(lines);

        if (Objects.equals(gestione.getTask().get(0), "TASK1") || Objects.equals(gestione.getTask().get(0), "TASK2") || Objects.equals(gestione.getTask().get(0), "TASK3")) {

            int prodottiTotali = gestione.getProdotti().size();
            int totaleMacchinariUtilizzati = 0;
            HashMap<String, Integer> macchinariUtilizzati = new HashMap<String, Integer>();
            HashMap<String, ArrayList<String>> macchinariImpiegati = new HashMap<String, ArrayList<String>>();
            boolean macchinarioImpiegatoProdotti = true;
            for (int i = 0; i < gestione.getProdotti().size(); i++) {
                for (int y = 0; y < gestione.getProdotti().get(i).getSequenza().length; y++) {
                    totaleMacchinariUtilizzati++;
                    if (!macchinariUtilizzati.containsKey(gestione.getProdotti().get(i).getSequenza()[y])) {
                        macchinariUtilizzati.put(gestione.getProdotti().get(i).getSequenza()[y], 1);
                    } else {
                        Integer count = macchinariUtilizzati.get(gestione.getProdotti().get(i).getSequenza()[y]);
                        macchinariUtilizzati.put(gestione.getProdotti().get(i).getSequenza()[y], count + 1);
                    }
                    if (!macchinariImpiegati.containsKey(gestione.getProdotti().get(i).getSequenza()[y])) {
                        ArrayList<String> categoria = new ArrayList<String>();
                        categoria.add(gestione.getProdotti().get(i).getCategoria());
                        macchinariImpiegati.put(gestione.getProdotti().get(i).getSequenza()[y], categoria);
                    } else {
                        ArrayList<String> categorie = new ArrayList<String>();
                        for (int z = 0; z < macchinariImpiegati.get(gestione.getProdotti().get(i).getSequenza()[y]).size(); z++) {
                            categorie.add(macchinariImpiegati.get(gestione.getProdotti().get(i).getSequenza()[y]).get(z));
                        }
                        categorie.add(gestione.getProdotti().get(i).getCategoria());
                        macchinariImpiegati.put(gestione.getProdotti().get(i).getSequenza()[y], categorie);
                        if (categorie.size() > 2) {
                            macchinarioImpiegatoProdotti = false;
                        }
                    }
                }
            }
            String macchinarioPiuUtilizzato = Collections.max(macchinariUtilizzati.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            int prodottiTotaliMicro = 0;
            int prodottiTotaliMacro = 0;
            int prodottiTotaliAggregato = 0;
            int macchinariMicro = 0;
            int macchinariMacro = 0;
            int macchinariAggregato = 0;
            String prodottoCatenaLunga = "";
            int lunghezzaCatena = 0;
            for (int i = 0; i < gestione.getProdotti().size(); i++) {
                if (Objects.equals(gestione.getProdotti().get(i).getCategoria(), "micro")) {
                    prodottiTotaliMicro++;
                    macchinariMicro += gestione.getProdotti().get(i).getSequenza().length;
                    if (gestione.getProdotti().get(i).getSequenza().length > lunghezzaCatena) {
                        lunghezzaCatena = gestione.getProdotti().get(i).getSequenza().length;
                        prodottoCatenaLunga = gestione.getProdotti().get(i).getCategoria();
                    }
                } else if (Objects.equals(gestione.getProdotti().get(i).getCategoria(), "macro")) {
                    prodottiTotaliMacro++;
                    macchinariMacro += gestione.getProdotti().get(i).getSequenza().length;
                    if (gestione.getProdotti().get(i).getSequenza().length >= lunghezzaCatena && !Objects.equals(prodottoCatenaLunga, "aggregato")) {
                        lunghezzaCatena = gestione.getProdotti().get(i).getSequenza().length;
                        prodottoCatenaLunga = gestione.getProdotti().get(i).getCategoria();
                    }
                } else if (Objects.equals(gestione.getProdotti().get(i).getCategoria(), "aggregato")) {
                    prodottiTotaliAggregato++;
                    macchinariAggregato += gestione.getProdotti().get(i).getSequenza().length;
                    if (gestione.getProdotti().get(i).getSequenza().length >= lunghezzaCatena) {
                        lunghezzaCatena = gestione.getProdotti().get(i).getSequenza().length;
                        prodottoCatenaLunga = gestione.getProdotti().get(i).getCategoria();
                    }
                }
            }
            int lavoratoriNonCoerenti = 0;
            for (int i = 0; i < gestione.getLavoratori().size(); i++) {
                List<String> macchinariAssegnati = new ArrayList<>(List.of(gestione.getLavoratori().get(i).getMacchinari()));
                Collections.sort(macchinariAssegnati);
                if (Objects.equals(gestione.getLavoratori().get(i).getRuolo(), "worker")) {
                    List<String> macchinariRuolo = new ArrayList<>(List.of(gestione.getCompetenze().get(0).getMacchinari()));
                    Collections.sort(macchinariRuolo);
                    if (!macchinariAssegnati.equals(macchinariRuolo)) {
                        lavoratoriNonCoerenti++;
                    }
                } else if (Objects.equals(gestione.getLavoratori().get(i).getRuolo(), "manager")) {
                    List<String> macchinariRuolo = new ArrayList<>(List.of(gestione.getCompetenze().get(1).getMacchinari()));
                    Collections.sort(macchinariRuolo);
                    if (!macchinariAssegnati.equals(macchinariRuolo)) {
                        lavoratoriNonCoerenti++;
                    }
                } else if (Objects.equals(gestione.getLavoratori().get(i).getRuolo(), "executive")) {
                    List<String> macchinariRuolo = new ArrayList<>(List.of(gestione.getCompetenze().get(2).getMacchinari()));
                    Collections.sort(macchinariRuolo);
                    if (!macchinariAssegnati.equals(macchinariRuolo)) {
                        lavoratoriNonCoerenti++;
                    }
                }
            }
            int macchinariA = 0;
            int macchinariB = 0;
            int macchinariC = 0;
            int macchinariD = 0;
            int macchinariE = 0;
            int macchinariConflitti = 0;
            int slotTemporale = 0;
            boolean macchinariConflittiReciproci = true;
            HashMap<String, String> unConflitto = new HashMap<String, String>();
            for (int i = 0; i < gestione.getMacchinari().size(); i++) {
                if (Objects.equals(gestione.getMacchinari().get(i).getZona(), "A")) {
                    macchinariA++;
                } else if (Objects.equals(gestione.getMacchinari().get(i).getZona(), "B")) {
                    macchinariB++;
                } else if (Objects.equals(gestione.getMacchinari().get(i).getZona(), "C")) {
                    macchinariC++;
                } else if (Objects.equals(gestione.getMacchinari().get(i).getZona(), "D")) {
                    macchinariD++;
                } else if (Objects.equals(gestione.getMacchinari().get(i).getZona(), "E")) {
                    macchinariE++;
                }
                if (Objects.equals(gestione.getTask().get(0), "TASK2")) {
                    if (gestione.getMacchinari().get(i).getConflitto().length > Integer.parseInt(gestione.getTask().get(2))) {
                        macchinariConflitti++;
                    }
                    if ((Integer.parseInt(gestione.getMacchinari().get(i).getOrario()[1]) - Integer.parseInt(gestione.getMacchinari().get(i).getOrario()[0])) > Integer.parseInt(gestione.getTask().get(3))) {
                        slotTemporale++;
                    }
                    for (int y = 0; y < gestione.getMacchinari().get(i).getConflitto().length; y++) {
                        if (!unConflitto.containsKey(gestione.getMacchinari().get(i).getConflitto()[y])) {
                            unConflitto.put(gestione.getMacchinari().get(i).getConflitto()[y], gestione.getMacchinari().get(i).getConflitto()[y]);
                        } else {
                            macchinariConflittiReciproci = false;
                        }
                    }
                }
            }
            boolean macchinariConflittiTotali = false;
            boolean macchinariSlotTemporali = false;
            if (Objects.equals(gestione.getTask().get(0), "TASK2") && Integer.parseInt(gestione.getTask().get(1)) > macchinariConflitti) {
                macchinariConflittiTotali = true;
            }
            if (Objects.equals(gestione.getTask().get(0), "TASK2") && Integer.parseInt(gestione.getTask().get(1)) > slotTemporale) {
                macchinariSlotTemporali = true;
            }
            boolean slotTemporaliSovrapposti = true;
            boolean prodottoOgniCategoria = true;
            boolean maxMacchinariConflitto = true;
            if (Objects.equals(gestione.getTask().get(0), "TASK3")) {
                ArrayList<String> tipologiaProdotti = new ArrayList<String>();
                for (int i = 2; i < Integer.parseInt(gestione.getTask().get(1)) + 2; i++) {
                    for (int y = 0; y < Integer.parseInt(gestione.getTask().get(1)); y++) {
                        if (Objects.equals(gestione.getTask().get(i), gestione.getProdotti().get(y).getId())) {
                            tipologiaProdotti.add(gestione.getProdotti().get(y).getCategoria());
                            ArrayList<Integer> orariDuplicati = new ArrayList<Integer>();
                            ArrayList<String> tipologieMacchinari = new ArrayList<String>();
                            int conflitti = 0;
                            for (int z = 0; z < gestione.getProdotti().get(y).getSequenza().length; z++) {
                                for (int w = 0; w < gestione.getMacchinari().size(); w++) {
                                    if (Objects.equals(gestione.getProdotti().get(y).getSequenza()[z], gestione.getMacchinari().get(w).getId())) {
                                        tipologieMacchinari.add(gestione.getMacchinari().get(w).getTipologia());
                                        for (int u = Integer.parseInt(gestione.getMacchinari().get(w).getOrario()[0]); u <= Integer.parseInt(gestione.getMacchinari().get(w).getOrario()[1]); u++) {
                                            orariDuplicati.add(u);
                                        }
                                        for (int a = 0; a < gestione.getProdotti().get(y).getSequenza().length; a++) {
                                            if (Objects.equals(gestione.getProdotti().get(y).getSequenza()[a], gestione.getMacchinari().get(w).getId())) {
                                                continue;
                                            }
                                            if (Arrays.stream(gestione.getMacchinari().get(w).getConflitto()).anyMatch(gestione.getProdotti().get(y).getSequenza()[a]::equals)) {
                                                conflitti++;
                                            }
                                        }
                                    }
                                }
                            }
                            Set<Integer> orariSingoli = new HashSet<Integer>(orariDuplicati);
                            if (orariDuplicati.size() != orariSingoli.size()) {
                                slotTemporaliSovrapposti = false;
                            }
                            Set<String> tipologieMacchinariSingoli = new HashSet<String>(tipologieMacchinari);
                            if (tipologieMacchinariSingoli.size() != 2) {
                                prodottoOgniCategoria = false;
                            }
                            if (conflitti > 2) {
                                maxMacchinariConflitto = false;
                            }
                        }
                    }
                }
                Set<String> tipologiaProdottiSingoli = new HashSet<String>(tipologiaProdotti);
                if (tipologiaProdottiSingoli.size() != 3) {
                    prodottoOgniCategoria = false;
                }
            }

            if (Objects.equals(gestione.getTask().get(0), "TASK1")) {
                System.out.println(prodottiTotali + " " + totaleMacchinariUtilizzati);
                System.out.println(prodottiTotaliMicro + " " + prodottiTotaliMacro + " " + prodottiTotaliAggregato);
                System.out.println(macchinarioPiuUtilizzato);
                System.out.println(lavoratoriNonCoerenti);
                System.out.println(macchinariA + " " + macchinariB + " " + macchinariC + " " + macchinariD + " " + macchinariE);
                System.out.println(macchinariMicro + " " + macchinariMacro + " " + macchinariAggregato);
                System.out.println(prodottoCatenaLunga);
            } else if (Objects.equals(gestione.getTask().get(0), "TASK2")) {
                if (macchinariConflittiTotali && macchinariSlotTemporali && macchinariConflittiReciproci && macchinarioImpiegatoProdotti) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (Objects.equals(gestione.getTask().get(0), "TASK3")) {
                if (slotTemporaliSovrapposti && prodottoOgniCategoria && maxMacchinariConflitto) {
                    System.out.println("VALID");
                } else {
                    System.out.println("NOT VALID");
                }
            }

        }

        in.close();

    }
}