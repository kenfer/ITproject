/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_account;
import java.lang.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;


/**
 *
 * @author C
 */
public class Main_Window extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form Main_Window
     */
    public Main_Window() {
        initComponents();
        Show_listStudents_InJTable();

    }
    String ImgPath = null;
    int pos =0;
    
    
    
    private Connection getConnection(){
    
    Connection con = null;
    
        try {
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/list_students","root","kenzxokenz");
           // JOptionPane.showMessageDialog(null, "Connected");
            return con;
         
    }catch (SQLException ex) { 
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Not Connected");
             return null;
        }
  
    
   
}
    //check input fields
    
    public boolean checkInputs()
    {
    
    if (
 
           txt_name.getText() == null
          || txt_age.getText() == null
            || txt_id.getText() == null
           || txt_AddDate == null
            ){
    return false;
    }else
    {
       try{
       Float.parseFloat(txt_age.getText());
       return true; 
       
       
       
       }
       catch(Exception ex)
       {
       return false;
       
       
       }
    
    }
            
    
    
    }
    
    
    
    
    //resize img
    
    public ImageIcon ResizeImage(String imagePath, byte[] pic)
    {
    ImageIcon myImage = null;
    
    if (imagePath != null)
            {
            myImage = new ImageIcon(imagePath); 
           
            }else{
                    
                    myImage = new ImageIcon(pic);
                    
                    }
    Image img = myImage.getImage();
    Image img2 = img.getScaledInstance(lbl.getWidth(),lbl.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(img2);
    return image;
    
    
    }
    //Display Data in the JTable
    //    1 - Fill ArrayList with the Data
    
    public ArrayList<ListStudents>getListStudentsList()
    {
         ArrayList<ListStudents> listStudentsList = (ArrayList<ListStudents>) new ArrayList<ListStudents>();
            
            Connection con = getConnection();
            String query = "SELECT * FROM students";
            
            Statement st;
            ResultSet rs;
            
            
        try {
           
            st = con.createStatement();
            rs = st.executeQuery(query);
            ListStudents listStudents;
            
            while(rs.next())
            {
                listStudents = new ListStudents(rs.getInt("id"),rs.getString("name"),Float.parseFloat(rs.getString("age")),rs.getString("date"),rs.getBytes("picture"));
            listStudentsList.add(listStudents);
                
                
            }
          
             
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return listStudentsList;
    }   
    
    
    
    // 2-Populate the JTable List
     public final void Show_listStudents_InJTable()
     {
     
     
     ArrayList<ListStudents>list = getListStudentsList();
     DefaultTableModel model = (DefaultTableModel)JTable_ListStudents.getModel();
        model.setRowCount(0);
     Object[] row  = new Object[4];
     for(int i = 0 ; i < list.size(); i++)
     {
     row[0] = list.get(i).getId();
      row[1] = list.get(i).getName();
       row[2] = list.get(i).getDate();
        row[3] = list.get(i).getAge();
 

            model.addRow(row);
     }
     
     
     }

    /**
     *
     * @param index
     */
    public void ShowItem(int index)
   {
   txt_id.setText(Integer.toString(getListStudentsList().get(index).getId()));
  txt_name.setText(getListStudentsList().get(index).getName());
  txt_age.setText(Float.toString(getListStudentsList().get(index).getAge()));
   txt_AddDate.setText(getListStudentsList().get(index).getDate());
            lbl.setIcon(ResizeImage(null, getListStudentsList().get(index).getImage()));
//AddDate = new SimpleDateFormat("yyyy-mm-dd").parse((String)getListStudentsList().get(index).getAddDate());  
     
   
   }
            
    
    
    
    
      
    
    
    
  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_AddDate = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_ListStudents = new javax.swing.JTable();
        Btn_Choose_Image = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Btn_Insert = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("StudentID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Age:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("DateAdded:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Picture:");

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        txt_AddDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AddDateActionPerformed(evt);
            }
        });

        lbl.setBackground(new java.awt.Color(51, 102, 255));
        lbl.setOpaque(true);

        JTable_ListStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "StudentID", "Name", "DateAdded", "Age"
            }
        ));
        JTable_ListStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ListStudentsMouseClicked(evt);
            }
        });
        JTable_ListStudents.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                JTable_ListStudentsComponentShown(evt);
            }
        });
        JTable_ListStudents.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JTable_ListStudentsInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_ListStudents);

        Btn_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_Choose_Image.setText("Upload Picture/Change pic");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Update_Stud");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Admin_Menu");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Delete_Stud");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Btn_Insert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_Insert.setText("Add_Student");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        Btn_Previous.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_Previous.setText("<-Previous");

        Btn_Next.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_Next.setText(" Next->");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_First.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_First.setText("<< ----First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        Btn_Last.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_Last.setText("Last-->>");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_id))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(30, 30, 30)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_AddDate, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(txt_age)))))
                    .addComponent(Btn_Choose_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))))
                                .addGap(8, 8, 8))
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Btn_Choose_Image)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Choose_ImageActionPerformed
       JFileChooser file = new JFileChooser();
       file.setCurrentDirectory(new File(System.getProperty("user.home")));
              
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png"); 
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
         
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl.setIcon(ResizeImage(path, null));
            ImgPath = path;
            
            
        }else
        {
            System.out.println("No File Selected");
        
        
        }
            
    }//GEN-LAST:event_Btn_Choose_ImageActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void txt_AddDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AddDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AddDateActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
      
        if (checkInputs() && ImgPath != null )
      {
      
          try {
               Connection con = getConnection();
              java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO students(name ,age ,date ,id,picture) "
                     + "values(?,?,?,?,?) ");
              
                    ps.setString(1, txt_name.getText()); 
                    ps.setString(2, txt_age.getText());
                   ps.setString(3, txt_AddDate.getText());
                 ps.setString(4, txt_id.getText());
                  
               
              InputStream img = new FileInputStream(new File(ImgPath));
         ps.setBlob(5, img);
         ps.executeUpdate();
    
               JOptionPane.showMessageDialog(null, "Data Inserted");
          } catch (Exception ex) {
             ex.printStackTrace();
          }
      }else 
      {
      
      JOptionPane.showMessageDialog(null, "One or More Fields Are Empty");
      
      }
        System.out.println("Name =>" +txt_name.getText());
         System.out.println("Age =>" +txt_age.getText());
         System.out.println("Date =>" +txt_AddDate.getText());
            System.out.println("StudentID =>" +txt_id.getText());
          System.out.println("Image Status =>" +ImgPath);
        
    }//GEN-LAST:event_Btn_InsertActionPerformed
 
       

  
  
    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if (checkInputs() && txt_id.getText() != null)
    {
     Connection con = getConnection();
    String UpdateQuery = null;
    PreparedStatement ps = null;
   JOptionPane.showMessageDialog(null, "Data Update");
   
    
    
    //update without image
    if (ImgPath == null )
    {
    
        try {
               UpdateQuery = "UPDATE students SET name= ?, age = ? "
                    + ", date = ? WHERE id = ?";
     
               
            ps = (PreparedStatement) con.prepareStatement(UpdateQuery);
            ps.setString(1,txt_name.getText());
            ps.setString(2, txt_age.getText());
            ps.setString(3, txt_AddDate.getText());
            ps.setInt(4,Integer.parseInt(txt_id.getText()));
             ps.executeUpdate(); 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    }
    //update with image
    else 
    {
        try {
        InputStream img = new FileInputStream(new File(ImgPath));
        
        
        
        
     UpdateQuery = "UPDATE students SET name= ?, age = ? "
                    + ", date = ?,picture = ? WHERE id = ?";
     
      ps = (PreparedStatement) con.prepareStatement(UpdateQuery);
            ps.setString(1,txt_name.getText());
            ps.setString(2, txt_age.getText());
            ps.setString(3, txt_AddDate.getText());
            ps.setBlob(4, img);
            ps.setInt(5,Integer.parseInt(txt_id.getText()));
            ps.executeUpdate();
    Show_listStudents_InJTable();
        }catch(FileNotFoundException | SQLException | NumberFormatException ex)
        {
        
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    }else
    {
    JOptionPane.showMessageDialog(null, "Can't Update,Data is Null Please Enter Your Student-Id");
    
    }
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (!txt_id.getText().equals(""))
    {
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM students WHERE id = ?");
            int id = Integer.parseInt(txt_id.getText());
            ps.setInt(1, id); 
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "studentDelete");
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "student Not Delete");
        }
    
    } else
    {
    JOptionPane.showMessageDialog(null, "Can't Delete,Data is Null Please Enter Your Student-Id");
    
    }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
       pos = 0;
        ShowItem(pos);
        
        
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
       pos = getListStudentsList().size()-1;
        ShowItem(pos);
        
        
        
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void JTable_ListStudentsComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_JTable_ListStudentsComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_JTable_ListStudentsComponentShown

    private void JTable_ListStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ListStudentsMouseClicked
  int index = JTable_ListStudents.getSelectedRow();
  ShowItem(index);
        
        
        
        
    }//GEN-LAST:event_JTable_ListStudentsMouseClicked

    private void JTable_ListStudentsInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JTable_ListStudentsInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_JTable_ListStudentsInputMethodTextChanged

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main_Window().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Choose_Image;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JTable JTable_ListStudents;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTextField txt_AddDate;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables

   

   
   

  
}
