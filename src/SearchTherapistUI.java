
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.*;
import java.lang.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ROHIT
 */
public class SearchTherapistUI extends javax.swing.JFrame {

    ArrayList<Therapist> Data;
    Manager Mng;
    String website = "";
    int Budget;

    /**
     * Creates new form SearchTherapistUI
     */
    public SearchTherapistUI() {
        initComponents();
        Mng = new Manager();
        Data=new ArrayList<Therapist>();
        init();
    }

    public void init() {
        this.jLabel1.setText("<html>" + "<body>\n" + "<p style='text-align:center'> Search<br> " + "Therapist\n</p>" + "</body>\n" + "</html>\n");

        if (Combo.getSelectedItem().toString().equalsIgnoreCase("None")) {
            Slider.disable();
            this.feeValLabel.setText("Budget Value :: None");
        } else {
            Slider.enable();
            Budget = this.Slider.getValue();
            this.feeValLabel.setText("Budget Value :: " + Integer.toString(Budget));
        }
//        System.out.println(Data.size());
        Data = Mng.getData();
//        System.out.println(Data.size());
        this.showTable();
        this.ShowAvailDay();

        ImageIcon icon2 = new ImageIcon("src/utils/logo.png");
        this.jLabel2.setIcon(resizeIcon(icon2, jLabel2.getWidth(), jLabel2.getHeight()));

    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void ShowAvailDay() {
        if (Table.getSelectedRow() != -1) {
            this.jPanel2.setVisible(true);
            this.VisitURL.setVisible(true);
            this.ClickHereLabel.setVisible(false);

        } else {

//            ClickHereLabel.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
            ClickHereLabel.setSize(new Dimension(341, 27));
//            ClickHereLabel.setForeground(new java.awt.Color(153, 255, 153));
            ClickHereLabel.setText(
                    "Click On Any Row For More Info.");

            this.ClickHereLabel.setVisible(true);
            this.jPanel2.setVisible(false);

            this.VisitURL.setVisible(false);
        }
    }

    public void showTable() {
           DefaultTableModel model = (DefaultTableModel) Table.getModel();
            // Delete Existing Rows
            int rows = model.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                model.removeRow(i);
            }
        if (Data.size()==0) {
            this.feeValLabel.setText("Please Select Another City");
            this.TheraVallabel.setText("No Therapist Found");
        } else {
//            this.feeValLabel.setText("Budget Value :: 1500");
            this.TheraVallabel.setText("Showing " + Data.size() + " Therapist");
          
            // Insert New Rows As Per Data
            Object rowData[] = new Object[6];
            for (int i = 0; i < Data.size(); i++) {
                rowData[0] = i + 1;
                rowData[1] = Data.get(i).getName();
                rowData[2] = Data.get(i).getFees();
                rowData[3] = Data.get(i).getExperience();
                rowData[4] = Data.get(i).getContactNumber();
                rowData[5] = Data.get(i).getAddress();
                model.addRow(rowData);
            }
            // Table.getColumnModel().getColumn(0).setPreferredWidth(10);
            // Table.getColumnModel().getColumn(2).setPreferredWidth(30);

        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        feeValLabel = new javax.swing.JLabel();
        VisitURL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        CB7 = new javax.swing.JCheckBox();
        CB5 = new javax.swing.JCheckBox();
        CB6 = new javax.swing.JCheckBox();
        CB2 = new javax.swing.JCheckBox();
        CB1 = new javax.swing.JCheckBox();
        CB4 = new javax.swing.JCheckBox();
        CB3 = new javax.swing.JCheckBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        feeLabel = new javax.swing.JLabel();
        Slider = new javax.swing.JSlider();
        cityLabel = new javax.swing.JLabel();
        Combo = new javax.swing.JComboBox<>();
        TheraVallabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        SortFees = new javax.swing.JRadioButton();
        SortExp = new javax.swing.JRadioButton();
        SortName = new javax.swing.JRadioButton();
        ClickHereLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(40, 153, 160));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(176, 221, 194), 8, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/arrow.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/home.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel3.setBackground(new java.awt.Color(147, 205, 186));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(133, 200, 173), 6, true));

        feeValLabel.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        feeValLabel.setForeground(new java.awt.Color(0, 88, 81));
        feeValLabel.setText("Budget Value :: 1500");
        feeValLabel.setMaximumSize(new java.awt.Dimension(500, 220));

        VisitURL.setBackground(new java.awt.Color(255, 102, 102));
        VisitURL.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        VisitURL.setForeground(new java.awt.Color(51, 0, 51));
        VisitURL.setText("VISIT URL");
        VisitURL.setToolTipText("");
        VisitURL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VisitURLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VisitURLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VisitURLMouseExited(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(133, 200, 173));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AvailDay", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel2.setToolTipText("");

        CB7.setForeground(new java.awt.Color(51, 255, 153));
        CB7.setText("SUN");
        CB7.setEnabled(false);

        CB5.setForeground(new java.awt.Color(51, 255, 153));
        CB5.setText("FRI");
        CB5.setEnabled(false);

        CB6.setForeground(new java.awt.Color(51, 255, 153));
        CB6.setText("SAT");
        CB6.setEnabled(false);

        CB2.setForeground(new java.awt.Color(51, 255, 153));
        CB2.setText("TUE");
        CB2.setEnabled(false);

        CB1.setForeground(new java.awt.Color(51, 255, 153));
        CB1.setText("MON");
        CB1.setEnabled(false);

        CB4.setForeground(new java.awt.Color(51, 255, 153));
        CB4.setText("THU");
        CB4.setEnabled(false);

        CB3.setForeground(new java.awt.Color(51, 255, 153));
        CB3.setText("WED");
        CB3.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CB7, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(CB5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CB3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CB3)
                        .addComponent(CB2))
                    .addComponent(CB1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB4)
                    .addComponent(CB6)
                    .addComponent(CB5))
                .addGap(18, 18, 18)
                .addComponent(CB7)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLayeredPane1.setBackground(new java.awt.Color(0, 204, 204));
        jLayeredPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jLayeredPane1.setForeground(new java.awt.Color(0, 204, 204));

        feeLabel.setBackground(new java.awt.Color(0, 153, 153));
        feeLabel.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        feeLabel.setForeground(new java.awt.Color(255, 255, 255));
        feeLabel.setText("Budget");

        Slider.setBackground(new java.awt.Color(153, 153, 153));
        Slider.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        Slider.setForeground(new java.awt.Color(51, 0, 51));
        Slider.setMajorTickSpacing(500);
        Slider.setMaximum(3500);
        Slider.setMinorTickSpacing(100);
        Slider.setPaintLabels(true);
        Slider.setPaintTicks(true);
        Slider.setSnapToTicks(true);
        Slider.setToolTipText("SelectBudget");
        Slider.setValue(1500);
        Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderStateChanged(evt);
            }
        });

        cityLabel.setBackground(new java.awt.Color(0, 153, 153));
        cityLabel.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        cityLabel.setForeground(new java.awt.Color(255, 255, 255));
        cityLabel.setText("Select City");

        Combo.setBackground(new java.awt.Color(102, 102, 102));
        Combo.setForeground(new java.awt.Color(255, 255, 255));
        Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Delhi", "Pune", "Hyderabad", "Kolkata", "Ranchi" }));
        Combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboItemStateChanged(evt);
            }
        });

        jLayeredPane1.setLayer(feeLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Slider, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cityLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(Combo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(feeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Slider, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TheraVallabel.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        TheraVallabel.setForeground(new java.awt.Color(0, 88, 81));
        TheraVallabel.setText("Showing 30 Therapist");

        jScrollPane3.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204), 3), " ListOfTherapist  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(153, 255, 153))); // NOI18N
        jScrollPane3.setForeground(new java.awt.Color(204, 255, 204));

        Table.setAutoCreateRowSorter(true);
        Table.setBackground(new java.awt.Color(204, 170, 145));
        Table.setForeground(new java.awt.Color(0, 0, 51));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TID", "Name", "Fees", "Experience", "Contact", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        Table.setFillsViewportHeight(true);
        Table.setFocusCycleRoot(true);
        Table.setGridColor(new java.awt.Color(204, 255, 204));
        Table.setSelectionBackground(new java.awt.Color(255, 204, 102));
        Table.setSelectionForeground(new java.awt.Color(0, 102, 102));
        Table.setShowGrid(true);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Table);

        jPanel8.setBackground(new java.awt.Color(133, 200, 173));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SortBy", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 51, 51))); // NOI18N

        buttonGroup1.add(SortFees);
        SortFees.setText("Fees");
        SortFees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SortFeesMouseClicked(evt);
            }
        });

        buttonGroup1.add(SortExp);
        SortExp.setText("Experience");
        SortExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SortExpMouseClicked(evt);
            }
        });

        buttonGroup1.add(SortName);
        SortName.setText("Name");
        SortName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SortNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SortExp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(SortFees, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SortName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SortName, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(SortFees, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(SortExp, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        ClickHereLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        ClickHereLabel.setForeground(new java.awt.Color(0, 88, 81));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(ClickHereLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addComponent(VisitURL, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(TheraVallabel, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                        .addGap(27, 27, 27))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(feeValLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(feeValLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(VisitURL, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TheraVallabel)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(ClickHereLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SortNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SortNameMouseClicked
        // TODO add your handling code here:
        Mng.sortData("Name");
        init();
    }//GEN-LAST:event_SortNameMouseClicked

    private void VisitURLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VisitURLMouseClicked

        if (!website.equals("")) {
            Mng.openWebsite(website);
        }
    }//GEN-LAST:event_VisitURLMouseClicked

    private void VisitURLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VisitURLMouseEntered
        VisitURL.setBackground(Color.green);
        VisitURL.setForeground(Color.red);
    }//GEN-LAST:event_VisitURLMouseEntered

    private void VisitURLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VisitURLMouseExited
       VisitURL.setBackground(new Color(255,102,102));
        VisitURL.setForeground(new Color(51,0,51));
    }//GEN-LAST:event_VisitURLMouseExited

    private void ComboItemStateChanged(java.awt.event.ItemEvent evt) {
        if (!Combo.getSelectedItem().toString().equalsIgnoreCase("None")) {
            Mng.filteredData(Combo.getSelectedItem().toString(), Budget);

        } else {
            Mng.allData();

        }

        this.buttonGroup1.clearSelection();

        init();

    }

    private void SliderStateChanged(javax.swing.event.ChangeEvent evt) {

        Mng.filteredData(Combo.getSelectedItem().toString(), Slider.getValue());
        try{
        String SortSelected=this.buttonGroup1.getSelection().toString();
        Mng.sortData(SortSelected);
        }
        catch(Exception ex){}
        init();
    }

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {
        this.ShowAvailDay();
        int row = Table.getSelectedRow();
        String[] p = Data.get(row).getAvailDay();
        website = Data.get(row).getWebsite();
        int CBIndex = 0;
        JCheckBox arr[] = {CB1, CB2, CB3, CB4, CB5, CB6, CB7};
        for (var i : p) {
            if (!i.equalsIgnoreCase("X")) {
                arr[CBIndex++].setSelected(true);
            } else {
                arr[CBIndex++].setSelected(false);
            }

        }
    }

    private void SortFeesMouseClicked(java.awt.event.MouseEvent evt) {

        Mng.sortData("Fees");

        init();
    }

    private void SortExpMouseClicked(java.awt.event.MouseEvent evt) {

        Mng.sortData("Experience");

        init();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SearchTherapistUI p = new SearchTherapistUI();
                p.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CB1;
    private javax.swing.JCheckBox CB2;
    private javax.swing.JCheckBox CB3;
    private javax.swing.JCheckBox CB4;
    private javax.swing.JCheckBox CB5;
    private javax.swing.JCheckBox CB6;
    private javax.swing.JCheckBox CB7;
    private javax.swing.JLabel ClickHereLabel;
    private javax.swing.JComboBox<String> Combo;
    private javax.swing.JSlider Slider;
    private javax.swing.JRadioButton SortExp;
    private javax.swing.JRadioButton SortFees;
    private javax.swing.JRadioButton SortName;
    private javax.swing.JTable Table;
    private javax.swing.JLabel TheraVallabel;
    private javax.swing.JButton VisitURL;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel feeLabel;
    private javax.swing.JLabel feeValLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
