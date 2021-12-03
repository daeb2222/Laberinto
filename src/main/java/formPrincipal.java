
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author_DieProgrammiere
 */
public class formPrincipal extends javax.swing.JFrame {

    DefaultListModel DLM = new DefaultListModel();
    char[][] mapa;
    Grafo grafoAux = new Grafo();
    ImageIcon LaberintoPng = new ImageIcon("LaberintoPng.png");
    ImageIcon popUp = new ImageIcon("popUp.png");
    String cadenaBFS = "";
    String cadenaDFS = "";

    /**
     * Creates new form fromPrinciapl
     */
    public formPrincipal() {
        initComponents();
        ImageIcon img = new ImageIcon("IconoLaberinto.png");
        mostrarMapaBot.setEnabled(false);
        mostrarLaberintoVacioBot.setEnabled(false);
        mostrarLaberintoResueltoBot.setEnabled(false);
        ResolverDFSbot.setEnabled(false);
        ResolverBFSbot.setEnabled(false);
        GuardarArchivoBot.setEnabled(false);
        this.setResizable(false);
        this.setIconImage(img.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PanelDeBotones = new javax.swing.JPanel();
        cargarArchivoBot = new javax.swing.JButton();
        salirBot = new javax.swing.JButton();
        ResolverDFSbot = new javax.swing.JButton();
        ResolverBFSbot = new javax.swing.JButton();
        mostrarMapaBot = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArchivos = new javax.swing.JList<String>();
        GuardarArchivoBot = new javax.swing.JButton();
        aboutUsBot = new javax.swing.JButton();
        ayudaBot = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaLaberintoVacio = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        mostrarLaberintoVacioBot = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaCaminoLaberinto = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaLaberintoResuelto = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        mostrarLaberintoResueltoBot = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LABYRINTH");
        setBackground(new java.awt.Color(67, 136, 142));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(LaberintoPng.getImage());
        setIconImages(null);
        setName("labyrinth"); // NOI18N

        jPanel1.setName("LABYRINTH"); // NOI18N

        PanelDeBotones.setBackground(new java.awt.Color(125, 196, 202));
        PanelDeBotones.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 136, 142)));
        PanelDeBotones.setForeground(new java.awt.Color(125, 196, 202));

        cargarArchivoBot.setText("Cargar Archivo");
        cargarArchivoBot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cargarArchivoBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoBotActionPerformed(evt);
            }
        });

        salirBot.setText("Salir");
        salirBot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        salirBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotActionPerformed(evt);
            }
        });

        ResolverDFSbot.setText("Resolver DFS");
        ResolverDFSbot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ResolverDFSbot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResolverDFSbotActionPerformed(evt);
            }
        });

        ResolverBFSbot.setText("Resolver BFS");
        ResolverBFSbot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ResolverBFSbot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResolverBFSbotActionPerformed(evt);
            }
        });

        mostrarMapaBot.setText("Mostrar Mapa");
        mostrarMapaBot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mostrarMapaBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarMapaBotActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 200, 190));
        jLabel2.setText("Labyrinth");

        listaArchivos.setBackground(new java.awt.Color(250, 200, 190));
        listaArchivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaArchivos.setSelectionBackground(new java.awt.Color(250, 200, 190));
        jScrollPane1.setViewportView(listaArchivos);

        GuardarArchivoBot.setText("Guardar archivo");
        GuardarArchivoBot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        GuardarArchivoBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarArchivoBotActionPerformed(evt);
            }
        });

        aboutUsBot.setText("Acerca de nosotros");
        aboutUsBot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        aboutUsBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutUsBotActionPerformed(evt);
            }
        });

        ayudaBot.setText("Ayuda");
        ayudaBot.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ayudaBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDeBotonesLayout = new javax.swing.GroupLayout(PanelDeBotones);
        PanelDeBotones.setLayout(PanelDeBotonesLayout);
        PanelDeBotonesLayout.setHorizontalGroup(
                PanelDeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDeBotonesLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PanelDeBotonesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelDeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ResolverBFSbot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ResolverDFSbot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(salirBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cargarArchivoBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mostrarMapaBot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addComponent(GuardarArchivoBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(aboutUsBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ayudaBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        PanelDeBotonesLayout.setVerticalGroup(
                PanelDeBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDeBotonesLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(ayudaBot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cargarArchivoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mostrarMapaBot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResolverDFSbot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResolverBFSbot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GuardarArchivoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aboutUsBot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salirBot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(125, 196, 202));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 136, 142)));
        jPanel3.setForeground(new java.awt.Color(125, 196, 202));

        textAreaLaberintoVacio.setEditable(false);
        textAreaLaberintoVacio.setBackground(new java.awt.Color(125, 196, 202));
        textAreaLaberintoVacio.setColumns(20);
        textAreaLaberintoVacio.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        textAreaLaberintoVacio.setRows(5);
        textAreaLaberintoVacio.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(textAreaLaberintoVacio);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 238, 200));
        jLabel1.setText("         LABERINTO SIN RESOLVER");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(132, 129, 129)));

        mostrarLaberintoVacioBot.setBackground(new java.awt.Color(125, 196, 202));
        mostrarLaberintoVacioBot.setForeground(new java.awt.Color(0, 153, 153));
        mostrarLaberintoVacioBot.setText("+");
        mostrarLaberintoVacioBot.setIcon(popUp);
        mostrarLaberintoVacioBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarLaberintoVacioBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(mostrarLaberintoVacioBot, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(mostrarLaberintoVacioBot, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(125, 196, 202));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 136, 142)));

        textAreaCaminoLaberinto.setBackground(new java.awt.Color(125, 196, 202));
        textAreaCaminoLaberinto.setColumns(20);
        textAreaCaminoLaberinto.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        textAreaCaminoLaberinto.setRows(5);
        jScrollPane4.setViewportView(textAreaCaminoLaberinto);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4)
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(125, 196, 202));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 136, 142)));

        textAreaLaberintoResuelto.setEditable(false);
        textAreaLaberintoResuelto.setBackground(new java.awt.Color(125, 196, 202));
        textAreaLaberintoResuelto.setColumns(20);
        textAreaLaberintoResuelto.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        textAreaLaberintoResuelto.setRows(5);
        jScrollPane3.setViewportView(textAreaLaberintoResuelto);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 238, 200));
        jLabel3.setText("              LABERINTO RESUELTO");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(132, 129, 129)));

        jButton3.setBackground(new java.awt.Color(125, 196, 202));
        jButton3.setForeground(new java.awt.Color(125, 196, 202));

        mostrarLaberintoResueltoBot.setBackground(new java.awt.Color(125, 196, 202));
        mostrarLaberintoResueltoBot.setForeground(new java.awt.Color(125, 196, 202));
        mostrarLaberintoResueltoBot.setText("+");
        mostrarLaberintoResueltoBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarLaberintoResueltoBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(mostrarLaberintoResueltoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(183, 183, 183)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(192, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(mostrarLaberintoResueltoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3)
                                .addContainerGap())
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(282, 282, 282)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(282, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(PanelDeBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelDeBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarArchivoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoBotActionPerformed
        mostrarLaberintoResueltoBot.setEnabled(false);
        mostrarLaberintoVacioBot.setEnabled(false);
        ResolverDFSbot.setEnabled(false);
        ResolverBFSbot.setEnabled(false);
        GuardarArchivoBot.setEnabled(false);
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text", "txt");
        fileChooser.addChoosableFileFilter(fileFilter);
        int chosen = fileChooser.showOpenDialog(cargarArchivoBot);
        if (chosen == 0 && fileChooser.getSelectedFile().toString().endsWith(".txt")) {
            String sAux = fileChooser.getSelectedFile().toString();
            DLM.addElement(sAux);
            listaArchivos.setModel(DLM);
            mostrarMapaBot.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(cargarArchivoBot, "Solo puedes usar archivos de texto \".txt\"");
        }
        textAreaLaberintoVacio.setText("");
        textAreaLaberintoResuelto.setText("");
        textAreaCaminoLaberinto.setText("");

    }//GEN-LAST:event_cargarArchivoBotActionPerformed

    private void salirBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirBotActionPerformed

    private void mostrarMapaBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarMapaBotActionPerformed

        if (listaArchivos.getSelectedIndices().length == 1) {
            String rutaArchivo = listaArchivos.getSelectedValue();
            mapa = Laberinto.cargaLaberinto(rutaArchivo);
            Laberinto.mostrarMapa(mapa, textAreaLaberintoVacio);
            textAreaLaberintoResuelto.setText("");
            textAreaCaminoLaberinto.setText("");
            mostrarLaberintoVacioBot.setEnabled(true);
            ResolverDFSbot.setEnabled(true);
            ResolverBFSbot.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(mostrarMapaBot, "Selecciona un archivo");
        }
    }//GEN-LAST:event_mostrarMapaBotActionPerformed

    private void ResolverDFSbotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResolverDFSbotActionPerformed
        Queue<String> cola = new LinkedList<String>();
        Queue<String> colaAux = new LinkedList<String>();
        Queue<String> colaAuxCopia = new LinkedList<String>();
        cola = Laberinto.EncontrarEntradaSalida(mapa);
        String inicio = cola.remove();
        String destino = cola.remove();
        grafoAux = Laberinto.creaGrafo(mapa);
        colaAux = grafoAux.DepthFirstSearch(inicio, destino);
        colaAuxCopia = clonarCola(colaAux);
        char[][] matrizAux = grafoAux.llenarMapa(colaAux, mapa);
        Laberinto.mostrarMapa(matrizAux, textAreaLaberintoResuelto);
        String cadena = "Camino Metodo DFS: ";
        cadena += "\n";
        for (String camino : colaAuxCopia) {
            cadena += "(" + camino + ")-> ";
        }
        textAreaCaminoLaberinto.setText(cadena);
        cadenaDFS = grafoAux.generaGrafo_ruta(colaAuxCopia, true);
        GuardarArchivoBot.setEnabled(true);
        mostrarLaberintoResueltoBot.setEnabled(true);
    }//GEN-LAST:event_ResolverDFSbotActionPerformed

    private void ResolverBFSbotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResolverBFSbotActionPerformed
        Queue<String> cola = new LinkedList<String>();
        Queue<String> colaAux = new LinkedList<String>();
        Queue<String> colaAuxCopia = new LinkedList<String>();
        cola = Laberinto.EncontrarEntradaSalida(mapa);
        String inicio = cola.remove();
        String destino = cola.remove();
        grafoAux = Laberinto.creaGrafo(mapa);
        colaAux = grafoAux.BreadthFirstSearch(inicio, destino);
        colaAuxCopia = clonarCola(colaAux);
        char[][] matrizAux = grafoAux.llenarMapa(colaAux, mapa);
        Laberinto.mostrarMapa(matrizAux, textAreaLaberintoResuelto);
        String cadena = "Camino Metodo BFS: ";
        cadena += "\n";
        for (String camino : colaAuxCopia) {
            cadena += "(" + camino + ")-> ";
        }
        textAreaCaminoLaberinto.setText(cadena);
        cadenaBFS = grafoAux.generaGrafo_ruta(colaAuxCopia, false);
        GuardarArchivoBot.setEnabled(true);
        mostrarLaberintoResueltoBot.setEnabled(true);
    }//GEN-LAST:event_ResolverBFSbotActionPerformed

    private Queue<String> clonarCola(Queue<String> colaRecibida) {
        Queue<String> cola = new LinkedList<>();
        for (String string : colaRecibida) {
            cola.add(string);
        }
        return cola;
    }

    private void mostrarLaberintoVacioBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarLaberintoVacioBotActionPerformed
        JFrame frame = new JFrame();
        Font consola = new Font("Consolas", 1, 18);
        frame.setTitle("Laberinto sin resolver");
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Color AzulPerry = new Color(125, 196, 202);
        textArea.setFont(consola);
        textArea.setBackground(AzulPerry);
        textArea.setText(textAreaLaberintoVacio.getText());
        frame.add(scroll);
        frame.setVisible(true);
        frame.pack();

    }//GEN-LAST:event_mostrarLaberintoVacioBotActionPerformed

    private void GuardarArchivoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarArchivoBotActionPerformed
        informacionArchivo(grafoAux.generaGrafo(cadenaBFS, cadenaDFS), "Labyrinth.dot");
        crearArchivo("Labyrinth.dot");
    }//GEN-LAST:event_GuardarArchivoBotActionPerformed

    private void ayudaBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaBotActionPerformed
        JOptionPane.showMessageDialog(ayudaBot,
                "1. Presiona el botón cargar archivo y elige un laberinto a resolver (archivo de tipo .txt)" + "\n"
                        + "2. Aplasta el botón de mostrar mapa para observar como se ve el laberinto sin resolver " + "\n"
                        + "3. Elige el metodo para encontrar el camino de tu laberinto (DFS o BFS)" + "\n"
                        + "4. Selecciona guardar archivo para obtener un archivo.dot con el grafo en formato GraphViz" + "\n"
                        + "5. Disfruta jugando con nuestro programa! :D " + "\n"
                        + "6. Para más información de los desarrollodres, presiona el botón ''Acerca de nosotros''" + "\n"
                        + "7. Cuando termines, puede aplastar el botón de salir " + "\n"
                        + "MUCHAS GRACIAS!", "Instrucciones", 1);

    }//GEN-LAST:event_ayudaBotActionPerformed

    private void aboutUsBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutUsBotActionPerformed
        JOptionPane.showMessageDialog(ayudaBot,
                "Equipo: " + "\n"
                        + "Die Programmierer " + "\n"
                        + "Integrantes: " + "\n"
                        + "-Barojas Alcantar Jared " + "\n"
                        + "-Espinoza Bernal Daniel Antonio" + "\n"
                        + "-Lerma Molina Karla Arleth " + "\n"
                        + "\n"
                        + "Materia: Fundamentos de computación III" + "\n"
                        + "Grupo: 1" + "\n"
                        + "Maestro: Federico Miguel Cirett Galan" + "\n"
                        + "Fecha: 3 de diciembre del 2021" + "\n");
    }//GEN-LAST:event_aboutUsBotActionPerformed

    private void mostrarLaberintoResueltoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarLaberintoResueltoBotActionPerformed
        JFrame frame = new JFrame();
        Font consola = new Font("Consolas", 1, 18);
        frame.setTitle("Laberinto resuelto");
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Color AzulPerry = new Color(125, 196, 202);
        textArea.setFont(consola);
        textArea.setBackground(AzulPerry);
        textArea.setText(textAreaLaberintoResuelto.getText());
        frame.add(scroll);
        frame.setVisible(true);
        frame.pack();
    }//GEN-LAST:event_mostrarLaberintoResueltoBotActionPerformed

    public void informacionArchivo(String grafo, String nombreArchivo) {
        try {
            PrintWriter writer = new PrintWriter(nombreArchivo);
            writer.println(grafo);
            writer.close();

        } catch (Exception e) {
            System.out.println("Ocurrió un error" + e.getMessage());
        }
    }

    public void crearArchivo(String nombreArchivo) {

        try {
            String rutaArchivo = new File(nombreArchivo).getAbsolutePath();
            File file = new File(rutaArchivo);

            if (!Desktop.isDesktopSupported()) {
                System.out.println("No compatible");
                return;
            }

            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error" + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarArchivoBot;
    private javax.swing.JPanel PanelDeBotones;
    private javax.swing.JButton ResolverBFSbot;
    private javax.swing.JButton ResolverDFSbot;
    private javax.swing.JButton aboutUsBot;
    private javax.swing.JButton ayudaBot;
    private javax.swing.JButton cargarArchivoBot;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listaArchivos;
    private javax.swing.JButton mostrarLaberintoResueltoBot;
    private javax.swing.JButton mostrarLaberintoVacioBot;
    private javax.swing.JButton mostrarMapaBot;
    private javax.swing.JButton salirBot;
    private javax.swing.JTextArea textAreaCaminoLaberinto;
    private javax.swing.JTextArea textAreaLaberintoResuelto;
    private javax.swing.JTextArea textAreaLaberintoVacio;
    // End of variables declaration//GEN-END:variables

}

