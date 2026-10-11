package physicsGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
import javax.crypto.SecretKey;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

//   Support: https://youtube.com/playlist?list=PLNHw_0qv1zy-cVdEX6HqJX2a8ZLHbG3Ox&feature=shared
//            https://youtube.com/playlist?list=PLBdxDGjena8FoQvZMsw_74esW4gY2FBRF&feature=shared
//            https://www.youtube.com/watch?v=zX6YtG20ScU
/**
 * GUI class for logging into main page.
 *
 * This interface allows users to enter a registered username and password to
 * enter the main page either as standard or admin user. Starting point of app
 * on execution.
 *
 * Features: - Scan AES file for registered accounts, if no account found
 * display error message - Able to be shown in Spanish, English and French -
 * Show/hide password toggle - Reset fields button - Uses focus listeners to
 * show message in fields if blank - Switch to enable/disable create account
 * button
 *
 * Dependencies: - EncryptionUtils for AES encryption operations -
 * Calculator_Interface_Light.java to use readPageManager method - Branching to
 * CreateAccount_Interface
 *
 * @author Harshil Shah
 */
public class Login_Interface extends javax.swing.JFrame {

    String defaultLogin = "UnitedGuest";
    String defaultPassword = "Admin";

    final String fileName = "AccountManagerAES.txt";
    final String pageManager = "pageManager.txt";
    String usernameInput;
    String passwordInput;
    String adminAccess = "Admin.true"; // Change admin keyword
    String style = "0";
    //int autoLogin = 1; // 1: On 0: off

    int createAccControl = 1; // 1 button on, 0 button off
    int hideCredentials = 0;
    
    private Calculator_Interface_Light homePage; // Reference to HomePage DO not remove

    /**
     * Creates new form GUI
     *
     * @param calcMainRef
     */
    public Login_Interface(/*Calculator_Interface_Light calcMainRef*/) {

        initComponents();
        //this.calcMainRef = calcMainRef;
        //txtPasswordSecured.setEchoChar('●'); // Hide text
        homePage = new Calculator_Interface_Light();
         Map<String, Boolean> pages = homePage.readPageManager(pageManager, ":");

        imgUnitedOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UnitedOSLogo.png")));

        imgUnitedOS.setVisible(false);

        File file = new File(fileName);
        if (file.exists()) {
            // Read the file

            System.out.println("file exsts");
        } else {
            System.out.println("File not found");
        }

        // Check if auto fill button is enabled
        boolean allowed = pages.getOrDefault("Quick Login", false);

        if (!allowed) {
            //homePage.pageDisabledMessage(); // print disabled message
            btnQuickLogin.setEnabled(false);
            btnQuickLogin.setVisible(false);
        }
        
        CreateAccount_Interface createAccount = new CreateAccount_Interface();

        // If saving to readable file is off, hide credentials
        if (createAccount.saveKey == false) {
            hideCredentials = 0;
        } else {
            hideCredentials = 1;
        }

        // Handles auto instructions for fields
        txtLogin.setText(" Enter Username");
        txtLogin.setForeground(new java.awt.Color(153, 153, 153)); // grey text

        txtPasswordSecured.setText(" Enter Password");
        txtPasswordSecured.setForeground(new java.awt.Color(153, 153, 153)); // grey text

        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtLogin.getText().trim().equals("Enter Username") || txtLogin.getText().trim().equals(" Enter Username")) {
                    txtLogin.setText("");
                    txtLogin.setForeground(new java.awt.Color(0, 0, 0)); // black text
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtLogin.getText().trim().isEmpty()) {
                    txtLogin.setText(" Enter Username");
                    txtLogin.setForeground(new java.awt.Color(153, 153, 153)); // grey text
                }
            }
        });

        txtPasswordSecured.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtPasswordSecured.getText().trim().equals("Enter Password") || txtPasswordSecured.getText().trim().equals(" Enter Password")) {
                    txtPasswordSecured.setText("");
                    txtPasswordSecured.setEchoChar('\u2022'); // Hide text
                    txtPasswordSecured.setForeground(new java.awt.Color(0, 0, 0)); // black text
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtPasswordSecured.getText().trim().isEmpty()) {
                    txtPasswordSecured.setText(" Enter Password");
                    txtPasswordSecured.setEchoChar('\u0000'); // Show text
                    txtPasswordSecured.setForeground(new java.awt.Color(153, 153, 153)); // grey text
                }
            }
        });

        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        // '=' key (Shift + '=' on most keyboards)
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "equalsPressed");

        actionMap.put("equalsPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.doClick(); // Simulate "=" button click
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordField = new javax.swing.JPasswordField();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        title = new javax.swing.JTextPane();
        startButton = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        txtPasswordSecured = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        btnQuickLogin = new javax.swing.JButton();
        btnCreateAcc = new javax.swing.JButton();
        tglPassword = new javax.swing.JToggleButton();
        imgUnitedOS = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuLanguage = new javax.swing.JMenu();
        chkmenuEnglish = new javax.swing.JCheckBoxMenuItem();
        chkmenuSpanish = new javax.swing.JCheckBoxMenuItem();
        chkmenuFrench = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        aboutCredits = new javax.swing.JMenuItem();

        passwordField.setEditable(false);
        passwordField.setActionCommand("<Not Set>");
        passwordField.setName("hii"); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("jRadioButtonMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Authentication Required");
        setBackground(new java.awt.Color(204, 255, 204));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        title.setEditable(false);
        title.setBackground(new java.awt.Color(204, 204, 255));
        title.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));
        title.setFont(new java.awt.Font("Kohinoor Devanagari", 1, 36)); // NOI18N
        title.setText(" United Operating System");
        title.setFocusCycleRoot(false);
        title.setFocusTraversalKeysEnabled(false);
        title.setFocusable(false);
        jScrollPane1.setViewportView(title);

        startButton.setBackground(new java.awt.Color(102, 204, 0));
        startButton.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 24)); // NOI18N
        startButton.setText("Go");
        startButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 255, 0)));
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        txtLogin.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(153, 153, 153));
        txtLogin.setText(" Enter Username");
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtLogin.setDragEnabled(true);
        txtLogin.setFocusTraversalPolicyProvider(true);
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        txtPasswordSecured.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        txtPasswordSecured.setForeground(new java.awt.Color(153, 153, 153));
        txtPasswordSecured.setText(" Enter Password");
        txtPasswordSecured.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPasswordSecured.setEchoChar('\u0000');
        txtPasswordSecured.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordSecuredKeyPressed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 153, 102));
        btnReset.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(51, 51, 51));
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnQuickLogin.setBackground(new java.awt.Color(102, 0, 255));
        btnQuickLogin.setForeground(new java.awt.Color(51, 255, 255));
        btnQuickLogin.setText("Quick Login");
        btnQuickLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuickLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickLoginActionPerformed(evt);
            }
        });

        btnCreateAcc.setBackground(new java.awt.Color(255, 153, 102));
        btnCreateAcc.setFont(new java.awt.Font("Kohinoor Gujarati", 0, 18)); // NOI18N
        btnCreateAcc.setText("Sign Up");
        btnCreateAcc.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 51, 51)));
        btnCreateAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccActionPerformed(evt);
            }
        });

        tglPassword.setBackground(new java.awt.Color(0, 51, 255));
        tglPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        tglPassword.setForeground(new java.awt.Color(255, 255, 255));
        tglPassword.setText("Show");
        tglPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tglPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglPasswordActionPerformed(evt);
            }
        });

        imgUnitedOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));
        imgUnitedOS.setOpaque(true);

        lblLogin.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblLogin.setText("Your Username");

        lblPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblPassword.setText("Your Password");

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        menuLanguage.setText("Language");
        menuLanguage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLanguage.setHideActionText(true);

        chkmenuEnglish.setSelected(true);
        chkmenuEnglish.setText("English");
        chkmenuEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkmenuEnglishActionPerformed(evt);
            }
        });
        menuLanguage.add(chkmenuEnglish);

        chkmenuSpanish.setText("Espanol");
        chkmenuSpanish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkmenuSpanishActionPerformed(evt);
            }
        });
        menuLanguage.add(chkmenuSpanish);

        chkmenuFrench.setText("French");
        chkmenuFrench.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkmenuFrenchActionPerformed(evt);
            }
        });
        menuLanguage.add(chkmenuFrench);

        jMenuBar1.add(menuLanguage);

        menuAbout.setText("About");
        menuAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        aboutCredits.setText("Credits");
        aboutCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutCreditsActionPerformed(evt);
            }
        });
        menuAbout.add(aboutCredits);

        jMenuBar1.add(menuAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgUnitedOS, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tglPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblLogin)
                                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnQuickLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPasswordSecured, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(46, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(18, 23, Short.MAX_VALUE)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordSecured, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglPassword)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgUnitedOS)
                    .addComponent(btnQuickLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
//        // TODO add your handling code here:
//        String defaultPassword = "HS24";
//        if (passwordField.equals(defaultPassword)) {
//            passwordField = "Accepted";
//        }
    }//GEN-LAST:event_passwordFieldActionPerformed


    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

//        String originalUser = txtLogin.getText();
//        String originalPass = txtPasswordSecured.getText();
//        String originalAdmin;
//        Updates fields
        inputer(txtLogin.getText(), txtPasswordSecured.getText(), adminAccess, style);

        int loginSuccess = 2;

        if (txtLogin.getText().equals(defaultLogin) && txtPasswordSecured.getText().equals(defaultPassword)) {

            loginSuccess = 3; // Administrator access with default key

        } else {
            loginSuccess = verifyUserLogin(usernameInput, passwordInput, fileName, ";", adminAccess);
        }

        if (loginSuccess == 1) {

            txtLogin.setBackground(new java.awt.Color(153, 255, 153));
            txtPasswordSecured.setBackground(new java.awt.Color(153, 255, 153));

            Calculator_Interface_Light passCredsNonAdmin = new Calculator_Interface_Light(usernameInput, passwordInput, "adminAccess.False");
            passCredsNonAdmin.setLocationRelativeTo(null); // centers frame
            passCredsNonAdmin.setVisible(true); // Use this object, not a new one make frame visible

            startButton.setText("Authentication Passed");
            System.out.println("Logged as regular");

            startButton.setEnabled(false);
            this.dispose();
        }
        if (loginSuccess == 3) {

            txtLogin.setBackground(new java.awt.Color(153, 255, 153));
            txtPasswordSecured.setBackground(new java.awt.Color(153, 255, 153));

            Calculator_Interface_Light passCredsAdmin = new Calculator_Interface_Light(usernameInput, passwordInput, "adminAccess.true");
            passCredsAdmin.setLocationRelativeTo(null); // centers frame
            passCredsAdmin.setVisible(true); // Use this object, not a new one make frame visible

            System.out.println("Logged as admin");
            startButton.setText("Logged in as Admin");

            startButton.setEnabled(false);
            this.dispose();
        }
        if (loginSuccess == 0) {

            txtLogin.setBackground(new java.awt.Color(255, 204, 204));
            txtPasswordSecured.setBackground(new java.awt.Color(255, 204, 204));

            if (txtLogin.getText().trim().isEmpty() && txtPasswordSecured.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Login_Interface.this, "Login Failed: Cannot be blank");
            } else {
                lblPassword.setText("Incorrect Password");
                JOptionPane.showMessageDialog(Login_Interface.this, "Login Failed: No Account Found");
            }

        }
        if (loginSuccess == 2) {
            lblLogin.setText("No Data");
            lblPassword.setText("Void File Detected");
        }

    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * Checks the entered credentials against the encrypted account store.
     *
     * @param username username to verify
     * @param password password to verify
     * @param filepath encrypted account file to read
     * @param delimiter separator between encrypted account fields
     * @param adminAccess administrator marker expected for privileged accounts
     * @return the status code used by the login flow
     */
    public int verifyUserLogin(String username, String password, String filepath, String delimiter, String adminAccess) {
        String currentLine;
        String[] data;

        if (txtLogin.getText().trim().isEmpty() && txtPasswordSecured.getText().trim().isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Login Failed: Cannot be blank");

            return 0;
        }

        try {

            FileReader reader = new FileReader(filepath);
            BufferedReader bReader = new BufferedReader(reader);

            EncryptionUtils encryptionUtils = new EncryptionUtils();
            SecretKey secretKey = EncryptionUtils.loadKey(); // Load the stored AES key

            while ((currentLine = bReader.readLine()) != null) {

                System.out.println("Raw Line from File: " + currentLine); // Debugging output
                data = currentLine.split(delimiter);

                System.out.println("Split Data Length: " + data.length); // Check how many parts are detected
                data = currentLine.split(delimiter);

                if (data.length >= 2) {

                    String decryptedUsername = EncryptionUtils.decrypt(data[0], secretKey);
                    String decryptedPassword = encryptionUtils.decrypt(data[1], secretKey);
                    String decryptedAdminAccess = encryptionUtils.decrypt(data[2], secretKey);
                    //this.style = data[3];

                    System.out.println(style);

                    System.out.println("Running Decryption");

                    //if (hideCredentials == 0) {
                    // Debugging output to check values
                    System.out.println("Stored Encrypted Username: " + data[0]);
                    System.out.println("Decrypted Username: " + decryptedUsername);
                    System.out.println("Input Username: " + username);
                    System.out.println("\nStored Encrypted Password: " + data[1]);
                    System.out.println("Decrypted Password: " + decryptedPassword);
                    System.out.println("Input Passwird: " + password);
                    //}

                    if (decryptedUsername.equals(username) && decryptedPassword.equals(password) && decryptedAdminAccess.equals(adminAccess)) {
                        System.out.println("Admin Login Detected");

                        return 3; // Admin Login
                    } else if (decryptedUsername.equals(username) && decryptedPassword.equals(password)) {
                        System.out.println("Regular User Login Detected");
                        return 1; // Regular User Login
                    }
                }
            }

            bReader.close();
        } catch (Exception e) {
            System.out.println("Error during decryption: " + e.getMessage());
        }

        return 0; // Login Failed

    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:

        lblLogin.setText("Enter Username:");
        lblPassword.setText("Enter Password:");

        // reset to hide defaultPassword field
        if (!tglPassword.isSelected()) {
            System.out.println("Password hidden");
            tglPassword.setText("Show");
            txtPasswordSecured.setEchoChar('●'); // Hide text
            tglPassword.setBackground(new java.awt.Color(0, 51, 255)); // set background to dark blue
            tglPassword.setForeground(new java.awt.Color(255, 255, 255)); // set text to white
        }

        txtLogin.setText("");
        txtPasswordSecured.setText("");
        txtLogin.setBackground(new java.awt.Color(255, 255, 255));
        txtPasswordSecured.setBackground(new java.awt.Color(255, 255, 255));

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnQuickLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickLoginActionPerformed
        // TODO add your handling code here:

        txtLogin.setForeground(new java.awt.Color(0, 102, 255));
        txtPasswordSecured.setForeground(new java.awt.Color(0, 102, 255));

        txtLogin.setText(defaultLogin);
        txtPasswordSecured.setText(defaultPassword);

    }//GEN-LAST:event_btnQuickLoginActionPerformed

    private void chkmenuEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkmenuEnglishActionPerformed
        // TODO add your handling code here:
        lblLogin.setText("Your Username:");
        lblPassword.setText("Your Password:");
        btnCreateAcc.setText("Sign Up");
        startButton.setText("Go");

        if (startButton.equals(true)) {
            startButton.setText("Go");
        }

        menuLanguage.setText("Language");
        chkmenuSpanish.setSelected(false);
        chkmenuFrench.setSelected(false);
    }//GEN-LAST:event_chkmenuEnglishActionPerformed

    private void chkmenuSpanishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkmenuSpanishActionPerformed
        // TODO add your handling code here:
        lblLogin.setText("Ingrese inicio de sesión:");
        lblPassword.setText("Ingrese la contraseña");
        btnCreateAcc.setText("Crear una cuenta");
        startButton.setText("Go");

        if (startButton.equals(true)) {
            startButton.setText("Vamos");
        }

        menuLanguage.setText("Idioma");
        chkmenuEnglish.setSelected(false);
        chkmenuFrench.setSelected(false);
    }//GEN-LAST:event_chkmenuSpanishActionPerformed

    private void chkmenuFrenchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkmenuFrenchActionPerformed
        // TODO add your handling code here:
        lblLogin.setText("Entrez la connexion");
        lblPassword.setText("Entrez le mot de passe");
        btnCreateAcc.setText("Créer un compte");
        startButton.setText("Se Connecter");

        if (startButton.equals(true)) {
            startButton.setText("cliquez pour commencer");
        }

        menuLanguage.setText("langue");
        chkmenuEnglish.setSelected(false);
        chkmenuSpanish.setSelected(false);
    }//GEN-LAST:event_chkmenuFrenchActionPerformed

    private void aboutCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutCreditsActionPerformed
        // TODO add your handling code here:

        new About_Interface().setVisible(true);
    }//GEN-LAST:event_aboutCreditsActionPerformed

    private void btnCreateAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccActionPerformed
        

        Map<String, Boolean> pages = homePage.readPageManager(pageManager, ":");

        // Check if the Accepted Acceleration page is enabled
        boolean allowed = pages.getOrDefault("Create Account", true);

        if (!allowed) {
            homePage.pageDisabledMessage(); // print disabled message

            return; // Stop

        }

        if (createAccControl == 1) { // If button enabled
            // Create an instance of Input_Interface
            CreateAccount_Interface createFrame = new CreateAccount_Interface();

            //205,240,235
            createFrame.getContentPane().setBackground(new java.awt.Color(205, 240, 235));

            // Center the frame on the screen
            //createFrame.setLocationRelativeTo(null);
            // Make the frame visible
            createFrame.setVisible(true);

        }
        if (createAccControl == 0) { //if button disabled
            btnCreateAcc.setBackground(Color.LIGHT_GRAY); // Set background color
            btnCreateAcc.setForeground(Color.LIGHT_GRAY); // Set foreground color
            JOptionPane.showMessageDialog(Login_Interface.this, "Create Account has been disabled");
        }


    }//GEN-LAST:event_btnCreateAccActionPerformed

    private void tglPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglPasswordActionPerformed
        

        if (tglPassword.isSelected()) {
            System.out.println("Password hidden");
            tglPassword.setText("Show");
            txtPasswordSecured.setEchoChar('\u2022'); // Hide text
            tglPassword.setBackground(new java.awt.Color(0, 51, 255)); // set background to dark blue
            tglPassword.setForeground(new java.awt.Color(255, 255, 255)); // set text to white

        } else {
            System.out.println("Password Revealed");
            tglPassword.setText("Hide");
            txtPasswordSecured.setEchoChar((char) 0); // Show text
            tglPassword.setBackground(new java.awt.Color(150, 171, 255));// set background to light blue
            tglPassword.setForeground(new java.awt.Color(0, 0, 0)); // set text to black

        }

    }//GEN-LAST:event_tglPasswordActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        

        //System.out.println("Key is pressed");
        /*

        if (txtLogin.getText().equals(" Enter Username")) {
            txtLogin.setText("");
            txtLogin.setForeground(new java.awt.Color(0, 0, 0)); // text to black
            clearUserLimit--;
        }
        else if(txtLogin.getText().isEmpty()) {
            txtLogin.setForeground(new java.awt.Color(153, 153, 153)); // text to grey
            txtLogin.setText(" Enter Username");
            clearUserLimit++;
        }
         */

    }//GEN-LAST:event_txtLoginKeyPressed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        

        System.out.println("pressed");
    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtPasswordSecuredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordSecuredKeyPressed
        

        /*
        if (clearPassLimit == 1) {
            txtPasswordSecured.setText("");
            txtPasswordSecured.setEchoChar('\u2022');
            clearPassLimit--;
        }

        txtPasswordSecured.setForeground(new java.awt.Color(0, 0, 0)); // text to black
         */
    }//GEN-LAST:event_txtPasswordSecuredKeyPressed

    public javax.swing.JTextField getTxtLogin() {
        return txtLogin;
    }

    public javax.swing.JPasswordField getTxtPasswordSecured() {
        return txtPasswordSecured;
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
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                // Create an instance of Input_Interface
                Login_Interface loginFrame = new Login_Interface();

                loginFrame.getTxtLogin().setFocusable(false); // disable focus on login field

                //205,240,235
                loginFrame.getContentPane().setBackground(new java.awt.Color(205, 240, 235));

                // Center the frame on the screen
                loginFrame.setLocationRelativeTo(null);

                // Make the frame visible
                loginFrame.setVisible(true);

                SwingUtilities.invokeLater(() -> loginFrame.getTxtLogin().setFocusable(true)); // Enable it again after GUI loads

            }
        });
    }

    public void inputer(String usernameInput, String passwordInput, String adminInput, String styleInput) {
        this.usernameInput = usernameInput;
        this.passwordInput = passwordInput;
        this.adminAccess = adminInput;
        this.style = styleInput;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutCredits;
    private javax.swing.JButton btnCreateAcc;
    private javax.swing.JButton btnQuickLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JCheckBoxMenuItem chkmenuEnglish;
    private javax.swing.JMenuItem chkmenuFrench;
    private javax.swing.JCheckBoxMenuItem chkmenuSpanish;
    private javax.swing.JLabel imgUnitedOS;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenu menuLanguage;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton startButton;
    private javax.swing.JToggleButton tglPassword;
    private javax.swing.JTextPane title;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPasswordSecured;
    // End of variables declaration//GEN-END:variables
}
