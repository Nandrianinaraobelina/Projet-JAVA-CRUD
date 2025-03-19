import com.mysql.cj.xdevapi.Table;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.io.*;//rehefa hanao exportation hiovaexcel
import java.io.FileFilter;//miaraka @io ambo,y io
public final class creationInterfaceCrud extends javax.swing.JFrame {

    private ResultSet resultat;


    public creationInterfaceCrud() {
        initComponents();
        Connect();
        afficheo();
        nyaffichage();
        ResultSet resultat;
        
    }
    Connection con;/*anaran'ilay coonection connection ako*/
    PreparedStatement coucouJava;
    
    public void Connect()
    {       /*MBA HIFANDRAY @ BD dia ITY FONCTION AMPESAINA: bdvarotra ny databases ako eto*/
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bdvarotrracrud","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficheo()
    {
        try {
            coucouJava = con.prepareStatement("SELECT id FROM produit_table");
            resultat = coucouJava.executeQuery();
            txtId.removeAllItems();
            while(resultat.next())
            {
                txtId.addItem(resultat.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /*HIRESAKA AN'ILAY AFICHAGE EO AMIN'NY TABLE*/
    private void nyaffichage(){
        try {
            int monVar;
            coucouJava = con.prepareStatement("SELECT * FROM produit_table");
           resultat = coucouJava.executeQuery();
           ResultSetMetaData toutstLesTable = resultat.getMetaData();
           monVar = toutstLesTable.getColumnCount();
           
            DefaultTableModel defaultTable = (DefaultTableModel)fenetreAffichage.getModel();
            defaultTable.setRowCount(0);
            while(resultat.next())
            {
                Vector n1 =new Vector();
                for(int a = 0; a <= monVar;a++)
                {
                    n1.add(resultat.getString("id"));
                    n1.add(resultat.getString("produit"));
                    n1.add(resultat.getString("prix"));
                    n1.add(resultat.getString("id"));
                }
                defaultTable.addRow(n1);
            }
           
           
           
        } catch (SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fenetreAffichage = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtproduit = new javax.swing.JTextField();
        txtprix = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtquantite = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAjouter = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(51, 51, 255));
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        fenetreAffichage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        fenetreAffichage.setForeground(new java.awt.Color(0, 0, 0));
        fenetreAffichage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUIT ID", "PRODUIT", "PRIX", "QUANTITE"
            }
        ));
        fenetreAffichage.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(fenetreAffichage);
        fenetreAffichage.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel5.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VOTRE MARCHANDISE");

        txtId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearch.setForeground(new java.awt.Color(0, 0, 0));
        btnSearch.setText("Recherche ID");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Votre ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 204));
        jPanel5.setName(""); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veuillez entrer votre produits", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Anarany Vokatra (Produit)");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("              Vidiny (Prix)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("                Quantite");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtproduit)
                    .addComponent(txtquantite, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprix, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproduit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprix, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquantite, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, new java.awt.Color(102, 102, 102)));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        btnAjouter.setBackground(new java.awt.Color(0, 204, 0));
        btnAjouter.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouter.setText("Ajouter");
        btnAjouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnModifier.setBackground(new java.awt.Color(255, 255, 0));
        btnModifier.setText("Modifier");
        btnModifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnSupprimer.setBackground(new java.awt.Color(255, 0, 0));
        btnSupprimer.setForeground(new java.awt.Color(255, 255, 255));
        btnSupprimer.setText("Supprimer");
        btnSupprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        btnExcel.setForeground(new java.awt.Color(0, 0, 0));
        btnExcel.setText("BD en EXCEL");
        btnExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcel)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CRUD 2025");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        /*FANAOVANA ILAY BTN AJOUTER*/
        try {
            String produit = txtproduit.getText();
            String prix = txtprix.getText();
            String quantite = txtquantite.getText();
            
            coucouJava = con.prepareStatement("INSERT INTO produit_table (produit,prix,quantite)VALUES(?,?,?) ");
            coucouJava.setString(1, produit);
            coucouJava.setString(2, prix);
            coucouJava.setString(3, quantite);
            
            int variableAko = coucouJava.executeUpdate();
            
            if(variableAko==1)
                
            {   /*MANDEFA An'ITY MESSAGE ITY IZY RAH NETY ILAY FAMPIDIRAN PRODUIT TEO @ILAY AJOUTER TEO*/
                JOptionPane.showMessageDialog(this,"felicitation!! tafiditra ny produit nataonao");
                txtproduit.setText("");
                txtprix.setText("");
                txtquantite.setText("");
                afficheo();
                nyaffichage();
                
            }
            else
            {
                /*MAZAVA HO AZY MOU ZAN RAH TSY TANTERAK LE CONDITION AMBONY DE MANDEF AN'ITY MESSAGE ITY NGA JAVA*/
                JOptionPane.showMessageDialog(this,"Misy tsy mety fa hamarino ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            
            // ETO ILAY BUTTON RECHERCHE ID: raha atao recher par ID ilay produit efa NISY tao
            
            String produitId = txtId.getSelectedItem().toString();
            coucouJava = con.prepareStatement("SELECT * FROM produit_table WHERE id = ?");
            coucouJava.setString(1,produitId);
            resultat = coucouJava.executeQuery();
            
            /*VERIFEKO PAR CONDITION ZAVATRA IO ALOHA*/
            
            if(resultat.next()== true)
            {
                txtproduit.setText(resultat.getString(2));
                txtprix.setText(resultat.getString(3));
                txtquantite.setText(resultat.getString(4));
            }
            
            /*RAHA TSY MISY ANATY BASE DE DONNER ILAY PRODUIT NEFA PAR ID NANAOVANY AZY DIA MIHATRA ny CONDITION ELSE*/
            
            else
            {
                JOptionPane.showMessageDialog(this,"Hamarino fa tsy misy zavatra tadiavinao");
            }
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        try {
            // ETO INDRAY NY BUTTON MISE A JOUR NO ATAO
            
            String produit = txtproduit.getText();
            String prix = txtprix.getText();
            String quantite = txtquantite.getText();
            String id = txtId.getSelectedItem().toString();
            
            coucouJava = con.prepareStatement("UPDATE produit_table SET produit=?, prix=?,quantite=? WHERE id=?");
            
            coucouJava.setString(1, produit);
            coucouJava.setString(2, prix);
            coucouJava.setString(3, quantite);
            coucouJava.setString(4, id);
            
            int variableAko = coucouJava.executeUpdate();
            
            if(variableAko==1)
                
            {   /*MANDEFA An'ITY MESSAGE ITY IZY RAH NETY ILAY MISE A JOUR PRODUIT TEO*/
                
                JOptionPane.showMessageDialog(this,"felicitation!! Vita Mise à jour ny produit anao");
                txtproduit.setText("");
                txtprix.setText("");
                txtquantite.setText("");
                txtproduit.requestFocus();
                afficheo();
                nyaffichage();
                
            }
            else
            {
                /*MAZAVA HO AZY MOU ZAN RAH TSY TANTERAK LE CONDITION AMBONY DE MANDEF AN'ITY MESSAGE ITY NGA JAVA*/
                JOptionPane.showMessageDialog(this,"Misy tsy mety fa hamarino ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModifierActionPerformed

    /*ETO ILAY FONCTION MAMAFA*/
    
    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        try {
            // VITA NY MAJ SY AJOUTER: HIDITRA SUPPRIMER INDRAY IZAO
            
            
            String id = txtId.getSelectedItem().toString();
            coucouJava = con.prepareStatement("DELETE FROM produit_table WHERE id=? ");
            coucouJava.setString(1, id);
             
            int variableAko = coucouJava.executeUpdate();
            
            if(variableAko==1)
                
            {   /*MANDEFA An'ITY MESSAGE ITY IZY RAH NETY ILAY MISE A JOUR PRODUIT TEO*/
                
                JOptionPane.showMessageDialog(this,"voafafa ilay produit safidinao ho fafana");
                txtproduit.setText("");
                txtprix.setText("");
                txtquantite.setText("");
                txtproduit.requestFocus();
                afficheo();
                nyaffichage();
                
            }
              else
            {
                /*MAZAVA HO AZY MOU ZAN RAH TSY TANTERAK LE CONDITION AMBONY DE MANDEF AN'ITY MESSAGE ITY NGA JAVA*/
                JOptionPane.showMessageDialog(this,"Misy erreur fa hamarino ilay zavatra hofafanao ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
     
        
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // MAMDIKA HO LASA EXCEL An'ILAY BD
        
       String filename = "D:\\Ity ilay fichier BD varotra.csv";//TOERANA ASIANA AZY RHF VO CREER
       
        try {
            FileWriter fw = new FileWriter(filename);
            coucouJava = con.prepareStatement("SELECT * FROM produit_table");
            resultat = coucouJava.executeQuery();
            
            while(resultat.next())
            {
             fw.append(resultat.getString(1));
             fw.append(',');
             fw.append(resultat.getString(2));
             fw.append(',');
             fw.append(resultat.getString(3));
             fw.append(',');
             fw.append(resultat.getString(4));
             fw.append('\n');
                    }
            JOptionPane.showMessageDialog(this,"Felicitation!! \n Votre BD excel est crée Monsieur Hery");
            fw.flush();
            fw.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(creationInterfaceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnExcelActionPerformed

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
            java.util.logging.Logger.getLogger(creationInterfaceCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(creationInterfaceCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(creationInterfaceCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(creationInterfaceCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new creationInterfaceCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JTable fenetreAffichage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> txtId;
    private javax.swing.JTextField txtprix;
    private javax.swing.JTextField txtproduit;
    private javax.swing.JTextField txtquantite;
    // End of variables declaration//GEN-END:variables
}
