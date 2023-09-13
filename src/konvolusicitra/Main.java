package konvolusicitra;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Main extends javax.swing.JFrame {
    private int[][] pixels = null;
    private int[][] mask; 
    private int h, w, mMask, nMask;
    private double constanta;
    private String type;
    
    public Main() {
        initComponents();
        setResizable(false);
        convolute.setEnabled(false);
        constanta = 1.0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uploadImg = new javax.swing.JButton();
        convolute = new javax.swing.JButton();
        filter = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 700));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setToolTipText("");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setToolTipText("");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        uploadImg.setText("Upload Image");
        uploadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImgActionPerformed(evt);
            }
        });

        convolute.setText("Convolute");
        convolute.setMaximumSize(new java.awt.Dimension(99, 23));
        convolute.setMinimumSize(new java.awt.Dimension(99, 23));
        convolute.setPreferredSize(new java.awt.Dimension(99, 23));
        convolute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convoluteActionPerformed(evt);
            }
        });

        filter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Jenis Filter.....", "Averaging Filter", "Box Filter", "Laplacian Filter", "High-pass Filter" }));
        filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 42, 235));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Image Convolution");

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("dmst");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uploadImg, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(convolute, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(168, 168, 168)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uploadImg, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(convolute, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImgActionPerformed
        JFileChooser filechooser= new JFileChooser();
        filechooser.setDialogTitle("Choose Your File");
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnval = filechooser.showOpenDialog(this);
        jLabel1.setIcon(null);
        jLabel2.setIcon(null);
        if(returnval == JFileChooser.APPROVE_OPTION){
            convolute.setEnabled(true);
            File file = filechooser.getSelectedFile();
            BufferedImage bf;
            Raster raster;
            try{
                bf = ImageIO.read(file);
                h = bf.getHeight();
                w = bf.getWidth();
                for(int i=0; i< w; i++){
                    for(int j=0; j< h; j++){
                        Color c = new Color(bf.getRGB(i, j));
                        int red = (int)(c.getRed() * 0.299);
                        int green = (int)(c.getGreen() * 0.587);
                        int blue = (int)(c.getBlue() *0.114);
                        Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);               
                        bf.setRGB(i,j,newColor.getRGB());
                    }
                }
                jLabel1.setIcon(new ImageIcon(bf));

                pixels = new int[h][w];
                raster = bf.getData();
                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < h; k++) {
                        pixels[k][j] = raster.getSample(j, k, 0);
                    }
                }
            }catch(IOException e){
            }
            this.pack();
        }
    }//GEN-LAST:event_uploadImgActionPerformed

    private void copyMatrix(int[][] source, int[][] origin){
        for(int i = 0; i < source.length; i++){
            origin[i] = source[i].clone();
        }
    }
    
    private void createImage(BufferedImage buff, int[][] pixel, int width, int height){
        for(int i=0; i < width; i++){
            for(int j=0; j < height; j++){
                Color newColor = new Color(pixel[j][i], pixel[j][i], pixel[j][i]);
                buff.setRGB(i, j, newColor.getRGB() );
            }
        }
        jLabel2.setIcon(new ImageIcon(buff));
    }
    
    private void convoluteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convoluteActionPerformed
        convolute.setEnabled(false);
        filter.setEnabled(false);
        int[][] newPixel = new int[h][w];
        copyMatrix(pixels, newPixel);
        for (int y = 1; y < h-1; y++){
            for (int x = 1; x < w-1; x++){
                //fetch an mini matriks
                int m = y - (int) Math.floor(mMask/2);
                int temp = 0;
                for (int i = 0; i < mMask; i++){
                    int n = x - (int) Math.floor(nMask/2);
                    for (int j = 0; j < nMask; j++){
                        temp += ( pixels[m][n] * mask[i][j] );
                        n++;
                    }
                    m++;
                }
                temp = (int) Math.floor(temp * constanta); //jika menggunakan avg atau box filter
                if(temp < 0){
                    newPixel[y][x] = 0;
                } else if(temp > 255){
                    newPixel[y][x] = 255;
                } else {
                    newPixel[y][x] = temp;
                }
            }
        }
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        createImage(bufferedImage, newPixel, w, h);
        filter.setEnabled(true);
    }//GEN-LAST:event_convoluteActionPerformed

    private void filterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterItemStateChanged
        type = filter.getSelectedItem().toString();
        if(!type.equalsIgnoreCase("Pilih Jenis Filter.....")){
            convolute.setEnabled(true);
            mask = new KernelMask().getMask(type);
            mMask = mask.length;
            nMask = mask.length;
            if(type.equalsIgnoreCase("Averaging Filter")){
                constanta = 0.0625;
            } else if(type.equalsIgnoreCase("Box Filter")){
                constanta = 0.1111;
            } else constanta = 1.0;
        }
    }//GEN-LAST:event_filterItemStateChanged

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convolute;
    private javax.swing.JComboBox filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton uploadImg;
    // End of variables declaration//GEN-END:variables
}
