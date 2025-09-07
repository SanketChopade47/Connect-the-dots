
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class connect extends Frame {

    CardLayout card = new CardLayout();
    Panel info = new Panel(new FlowLayout(0, 50, 5));// information bar
    Panel home = new Panel(new FlowLayout(1, 200, 200));// default home panel
    Panel ps = new Panel(card);// playsection panel
    Panel l1 = new Panel(new GridLayout(5, 5));// level1 panel
    Panel l2 = new Panel(new GridLayout(5, 5));// level2 panel
    Panel l3 = new Panel(new GridLayout(5, 5));// level3 panel
    Panel l4 = new Panel(new GridLayout(5, 5));// level4 panel
    Panel l5 = new Panel(new GridLayout(7, 7));// level5 panel
    Panel l6 = new Panel(new GridLayout(7, 7));// level6 panel
    Panel l7 = new Panel(new GridLayout(7, 7));// level7 panel
    Panel l8 = new Panel(new GridLayout(9, 9));// level8 panel
    Panel l9 = new Panel(new GridLayout(9, 9));// level9 panel
    Panel ending = new Panel(new FlowLayout(1, 200, 200));// ending panel
    // flags
    boolean redclickedS = false;
    boolean blueclickedS = false;
    boolean yellowclickedS = false;
    boolean orangeclickedS = false;
    boolean violetclickedS = false;
    boolean purpleclickedS = false;
    boolean greenclickedS = false;
    boolean silverclickedS = false;
    boolean tealclickedS = false;

    boolean redclickedE = false;
    boolean blueclickedE = false;
    boolean yellowclickedE = false;
    boolean orangeclickedE = false;
    boolean violetclickedE = false;
    boolean purpleclickedE = false;
    boolean greenclickedE = false;
    boolean silverclickedE = false;
    boolean tealclickedE = false;

    boolean redjoint = false;
    boolean bluejoint = false;
    boolean yellowjoint = false;
    boolean orangejoint = false;
    boolean violetjoint = false;
    boolean purplejoint = false;
    boolean greenjoint = false;
    boolean silverjoint = false;
    boolean tealjoint = false;

    // co-ordinates of tiles
    int redS, redE, blueS, blueE, yellowS, yellowE, orangeS, orangeE, purpleS, purpleE, violetS, violetE, greenS,
            greenE, silverE, silverS, tealE, tealS;
    int currlevel = 0;

    Button tempbutton;
    Font defaultf = new Font("Verdana", Font.BOLD, 40);
    Font lf = new Font("Verdana", Font.BOLD, 20);

    Button start = new Button("START");
    Button reset = new Button("RESET");
    Button next = new Button("next");
    Button prev = new Button("prev");

    Button[] tiles = new Button[100];// tiles

    JLabel levelLable = new JLabel("HOME");

    connect() {
        levelLable.setFont(lf);
        info.add(levelLable);
        info.add(reset);
        info.add(next);// next button
        info.add(prev);// prev button

        reset.setVisible(false);
        setTitle("CONNECT THE DOTS");
        setSize(800, 800);
        setLocationRelativeTo(getFocusCycleRootAncestor());
        setResizable(false);
        setLayout(new BorderLayout());
        start.addActionListener(new actionHandler());
        reset.addActionListener(new actionHandler());
        next.addActionListener(new actionHandler());// next button
        prev.addActionListener(new actionHandler());// prev button

        add(info, "North");
        add(ps, "Center");

        info.setBackground(Color.ORANGE);
        ps.setBackground(Color.DARK_GRAY);

        Label welcomemsg = new Label("CONNECT THE DOTS ");

        welcomemsg.setFont(defaultf);
        welcomemsg.setForeground(Color.WHITE);

        home.add(welcomemsg);
        home.add(start);
        ps.add(home);
        ps.add(l1);
        ps.add(l2);
        ps.add(l3);
        ps.add(l4);
        ps.add(l5);
        ps.add(l6);
        ps.add(l7);
        ps.add(l8);
        ps.add(l9);
        ps.add(ending);
    }

    class mouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            Button temp = (Button) e.getSource();
            System.out.println("pressed");
            System.out.println(temp.getLabel());

            if (temp == tiles[redS] && redjoint == false) {
                redclickedS = true;
                System.out.println("RED CLICKED");
            } else if (temp == tiles[blueS] && bluejoint == false) {
                blueclickedS = true;
                System.out.println("blue CLICKED");
            } else if (temp == tiles[yellowS] && yellowjoint == false) {
                yellowclickedS = true;
                System.out.println("yellow CLICKED");
            } else if (temp == tiles[orangeS] && orangejoint == false) {
                orangeclickedS = true;
                System.out.println("orange CLICKED");
            } else if (temp == tiles[redE] && redjoint == false) {
                redclickedE = true;
                System.out.println("RED CLICKED");
            } else if (temp == tiles[blueE] && bluejoint == false) {
                blueclickedE = true;
                System.out.println("blue CLICKED");
            } else if (temp == tiles[yellowE] && yellowjoint == false) {
                yellowclickedE = true;
                System.out.println("yellow CLICKED");
            } else if (temp == tiles[orangeE] && orangejoint == false) {
                orangeclickedE = true;
                System.out.println("orange CLICKED");
            } else if (temp == tiles[violetE] && violetjoint == false) {
                violetclickedE = true;
                System.out.println("violet CLICKED");
            } else if (temp == tiles[violetS] && violetjoint == false) {
                violetclickedS = true;
                System.out.println("violet CLICKED");
            } else if (temp == tiles[purpleE] && purplejoint == false) {
                purpleclickedE = true;
                System.out.println("purple CLICKED");
            } else if (temp == tiles[purpleS] && purplejoint == false) {
                purpleclickedS = true;
                System.out.println("purple CLICKED");
            } else if (temp == tiles[greenE] && greenjoint == false) {
                greenclickedE = true;
                System.out.println("green CLICKED");
            } else if (temp == tiles[greenS] && greenjoint == false) {
                greenclickedS = true;
                System.out.println("green CLICKED");
            } else if (temp == tiles[silverE] && silverjoint == false) {
                silverclickedE = true;
                System.out.println("silver CLICKED");
            } else if (temp == tiles[silverS] && silverjoint == false) {
                silverclickedS = true;
                System.out.println("silver CLICKED");
            } else if (temp == tiles[tealE] && tealjoint == false) {
                tealclickedE = true;
                System.out.println("teal CLICKED");
            } else if (temp == tiles[tealS] && tealjoint == false) {
                tealclickedS = true;
                System.out.println("teal CLICKED");
            }
        }

        public void mouseEntered(MouseEvent e) {
            Button temp = (Button) e.getSource();
            tempbutton = (Button) e.getSource();
            String label = temp.getLabel();

            if (redclickedS || redclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    redclickedS = false;
                    resetRED();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    redclickedS = false;
                    resetRED();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    redclickedS = false;
                    resetRED();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    redclickedS = false;
                    resetRED();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    redclickedS = false;
                    resetRED();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    redclickedS = false;
                    resetRED();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    redclickedS = false;
                    resetRED();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    redclickedS = false;
                    resetRED();
                } else {
                    if (temp == tiles[redE] || temp == tiles[redS]) {
                    } else {
                        temp.setBackground(Color.RED);
                        temp.setLabel("occupiedRED");
                        temp.setForeground(Color.RED);
                        System.out.println("else red");
                    }
                }

            } else if (blueclickedS || blueclickedE) {
                if (label == "occupiedRED" || label == "fixedR") {
                    blueclickedS = false;
                    resetBLUE();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    blueclickedS = false;
                    resetBLUE();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    blueclickedS = false;
                    resetBLUE();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    blueclickedS = false;
                    resetBLUE();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    blueclickedS = false;
                    resetBLUE();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    blueclickedS = false;
                    resetBLUE();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    blueclickedS = false;
                    resetBLUE();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    blueclickedS = false;
                    resetBLUE();
                } else {
                    if (temp == tiles[blueE] || temp == tiles[blueS]) {
                    } else {
                        temp.setBackground(Color.blue);
                        temp.setLabel("occupiedBLUE");
                        temp.setForeground(Color.BLUE);
                        System.out.println("else blue");
                    }
                }

            } else if (yellowclickedS || yellowclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else if (label == "occupiedRED" || label == "fixedR") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    yellowclickedS = false;
                    resetYELLOW();
                } else {
                    if (temp == tiles[yellowE] || temp == tiles[yellowS]) {
                    } else {
                        temp.setBackground(Color.YELLOW);
                        temp.setLabel("occupiedYELLOW");
                        temp.setForeground(Color.YELLOW);
                        System.out.println("else YELLOW");
                    }
                }
            } else if (orangeclickedS || orangeclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    orangeclickedS = false;
                    resetORANGE();
                } else if (label == "occupiedRED" || label == "fixedR") {
                    orangeclickedS = false;
                    resetORANGE();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    orangeclickedS = false;
                    resetORANGE();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    orangeclickedS = false;
                    resetORANGE();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    orangeclickedS = false;
                    resetORANGE();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    orangeclickedS = false;
                    resetORANGE();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    orangeclickedS = false;
                    resetORANGE();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    orangeclickedS = false;
                    resetORANGE();
                } else {
                    if (temp == tiles[orangeE] || temp == tiles[orangeS]) {
                    } else {
                        temp.setBackground(Color.ORANGE);
                        temp.setLabel("occupiedORANGE");
                        temp.setForeground(Color.ORANGE);
                        System.out.println("else ORANGE");
                    }
                }
            } else if (purpleclickedS || purpleclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else if (label == "occupiedRED" || label == "fixedR") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    purpleclickedS = false;
                    resetPURPLE();
                } else {
                    if (temp == tiles[purpleE] || temp == tiles[purpleS]) {
                    } else {
                        temp.setBackground(new Color(192, 0, 255));
                        temp.setLabel("occupiedPURPLE");
                        temp.setForeground(new Color(192, 0, 255));
                        System.out.println("else PURPLE");
                    }
                }
            } else if (violetclickedS || violetclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    violetclickedS = false;
                    resetVIOLET();
                } else if (label == "occupiedRED" || label == "fixedR") {
                    violetclickedS = false;
                    resetVIOLET();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    violetclickedS = false;
                    resetVIOLET();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    violetclickedS = false;
                    resetVIOLET();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    violetclickedS = false;
                    resetVIOLET();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    violetclickedS = false;
                    resetVIOLET();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    violetclickedS = false;
                    resetVIOLET();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    violetclickedS = false;
                    resetVIOLET();
                } else {
                    if (temp == tiles[violetE] || temp == tiles[violetS]) {
                    } else {
                        temp.setBackground(new Color(143, 0, 255));
                        temp.setLabel("occupiedVIOLET");
                        temp.setForeground(new Color(143, 0, 255));
                        System.out.println("else VIOLET");
                    }
                }
            } else if (greenclickedS || greenclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    resetGREEN();
                } else if (label == "occupiedRED" || label == "fixedR") {
                    resetGREEN();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    resetGREEN();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    resetGREEN();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    resetGREEN();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    resetGREEN();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    resetGREEN();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    resetGREEN();
                } else {
                    if (temp == tiles[violetE] || temp == tiles[violetS]) {
                    } else {
                        temp.setBackground(Color.GREEN);
                        temp.setLabel("occupiedGREEN");
                        temp.setForeground(Color.GREEN);
                        System.out.println("else GREEN");
                    }
                }
            } else if (silverclickedS || silverclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    resetSILVER();
                } else if (label == "occupiedRED" || label == "fixedR") {
                    resetSILVER();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    resetSILVER();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    resetSILVER();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    resetSILVER();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    resetSILVER();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    resetSILVER();
                } else if (label == "occupiedTEAL" || label == "fixedT") {
                    resetSILVER();
                } else {
                    if (temp == tiles[silverE] || temp == tiles[silverS]) {
                    } else {
                        temp.setBackground(new Color(192, 192, 192));
                        temp.setLabel("occupiedSILVER");
                        temp.setForeground(new Color(192, 192, 192));
                        System.out.println("else SILVER");
                    }
                }
            } else if (tealclickedS || tealclickedE) {
                if (label == "occupiedBLUE" || label == "fixedB") {
                    resetTEAL();
                } else if (label == "occupiedRED" || label == "fixedR") {
                    resetTEAL();
                } else if (label == "occupiedYELLOW" || label == "fixedY") {
                    resetTEAL();
                } else if (label == "occupiedPURPLE" || label == "fixedP") {
                    resetTEAL();
                } else if (label == "occupiedORANGE" || label == "fixedO") {
                    resetTEAL();
                } else if (label == "occupiedGREEN" || label == "fixedG") {
                    resetTEAL();
                } else if (label == "occupiedVIOLET" || label == "fixedV") {
                    resetTEAL();
                } else if (label == "occupiedSILVER" || label == "fixedS") {
                    resetTEAL();
                } else {
                    if (temp == tiles[tealE] || temp == tiles[tealS]) {
                    } else {
                        temp.setBackground(new Color(0, 128, 128));
                        temp.setLabel("occupiedTEAL");
                        temp.setForeground(new Color(0, 128, 128));
                        System.out.println("else TEAL");
                    }
                }
            }

        }

        public void mouseReleased(MouseEvent e) {
            if ((redclickedS || redclickedE) && !((tempbutton == tiles[redE]) || (tempbutton == tiles[redS]))) {
                resetRED();
            } else if ((blueclickedS || blueclickedE)
                    && !((tempbutton == tiles[blueE]) || tempbutton == tiles[blueS])) {
                resetBLUE();
            } else if ((yellowclickedS || yellowclickedE)
                    && !((tempbutton == tiles[yellowE]) || (tempbutton == tiles[yellowS]))) {
                resetYELLOW();
            } else if ((orangeclickedS || orangeclickedE)
                    && !((tempbutton == tiles[orangeE]) || (tempbutton == tiles[orangeS]))) {
                resetORANGE();
            } else if ((purpleclickedS || purpleclickedE)
                    && !((tempbutton == tiles[purpleE]) || (tempbutton == tiles[purpleS]))) {
                resetPURPLE();
            } else if ((violetclickedS || violetclickedE)
                    && !((tempbutton == tiles[violetE]) || (tempbutton == tiles[violetS]))) {
                resetVIOLET();
            } else if ((greenclickedS || greenclickedE)
                    && !((tempbutton == tiles[greenE]) || (tempbutton == tiles[greenS]))) {
                resetGREEN();
            } else if ((silverclickedS || silverclickedE)
                    && !((tempbutton == tiles[silverE]) || (tempbutton == tiles[silverS]))) {
                resetSILVER();
            } else if ((tealclickedS || tealclickedE)
                    && !((tempbutton == tiles[tealE]) || (tempbutton == tiles[tealS]))) {
                resetTEAL();
            }

            if (tempbutton == tiles[redE] && redclickedS) {
                redjoint = true;
                System.out.println("joint r");
            } else if (tempbutton == tiles[blueE] && blueclickedS) {
                bluejoint = true;
                System.out.println("joint b");
            } else if (tempbutton == tiles[yellowE] && yellowclickedS) {
                yellowjoint = true;
                System.out.println("joint y");
            } else if (tempbutton == tiles[orangeE] && orangeclickedS) {
                orangejoint = true;
                System.out.println("joint o");
            } else if (tempbutton == tiles[purpleE] && purpleclickedS) {
                purplejoint = true;
                System.out.println("joint p");
            } else if (tempbutton == tiles[violetE] && violetclickedS) {
                violetjoint = true;
                System.out.println("joint v");
            } else if (tempbutton == tiles[greenE] && greenclickedS) {
                greenjoint = true;
                System.out.println("joint g");
            } else if (tempbutton == tiles[silverE] && silverclickedS) {
                silverjoint = true;
                System.out.println("joint s");
            } else if (tempbutton == tiles[tealE] && tealclickedS) {
                tealjoint = true;
                System.out.println("joint t");
            } else {
                System.out.println("missed");
            }

            if (tempbutton == tiles[redS] && redclickedE) {
                redjoint = true;
                System.out.println("joint r");
            } else if (tempbutton == tiles[blueS] && blueclickedE) {
                bluejoint = true;
                System.out.println("joint b");
            } else if (tempbutton == tiles[yellowS] && yellowclickedE) {
                yellowjoint = true;
                System.out.println("joint y");
            } else if (tempbutton == tiles[orangeS] && orangeclickedE) {
                orangejoint = true;
                System.out.println("joint o");
            } else if (tempbutton == tiles[purpleS] && purpleclickedE) {
                purplejoint = true;
                System.out.println("joint p");
            } else if (tempbutton == tiles[violetS] && violetclickedE) {
                violetjoint = true;
                System.out.println("joint v");
            } else if (tempbutton == tiles[greenS] && greenclickedE) {
                greenjoint = true;
                System.out.println("joint g");
            } else if (tempbutton == tiles[silverS] && silverclickedE) {
                silverjoint = true;
                System.out.println("joint s");
            } else if (tempbutton == tiles[tealS] && tealclickedE) {
                tealjoint = true;
                System.out.println("joint t");
            } else {
                System.out.println("missed");
            }

            redclickedS = false;
            redclickedE = false;
            blueclickedS = false;
            blueclickedE = false;
            yellowclickedS = false;
            yellowclickedE = false;
            orangeclickedS = false;
            orangeclickedE = false;
            violetclickedE = false;
            violetclickedS = false;
            purpleclickedE = false;
            purpleclickedS = false;
            greenclickedE = false;
            greenclickedS = false;
            silverclickedE = false;
            silverclickedS = false;
            tealclickedE = false;
            tealclickedS = false;

            int[] l1red = { 3, 2, 7, 12, 11 };
            int[] l1yellow = { 0, 1, 6 };
            int[] l1orange = { 4, 9, 8, 13, 18, 17, 16 };
            int[] l1blue = { 5, 10, 15, 20, 21, 22, 23, 24, 19, 14 };

            int[] l2red = { 12, 7, 2, 3, 4, 9, 14 };
            int[] l2yellow = { 0, 1, 6, 11, 16, 17, 22, 23, 24 };
            int[] l2orange = { 8, 13, 18, 19 };
            int[] l2blue = { 5, 10, 15, 20, 21 };

            int[] l3red = { 4, 9, 8, 7, 6, 11, 16, 21, 22, 23 };
            int[] l3yellow = { 3, 2, 1, 0, 5, 10, 15, 20 };
            int[] l3blue = { 12, 17, 18 };
            int[] l3orange = { 13, 14, 19, 24 };

            int[] l4red = { 6, 11, 16, 17 };
            int[] l4yellow = { 4, 3, 2, 1, 0, 5, 10, 15, 20, 21 };
            int[] l4blue = { 12, 13, 18, 23, 22 };
            int[] l4orange = { 7, 8, 9, 14, 19, 24 };

            int[] l5red = { 16, 17, 24, 31 };
            int[] l5orange = { 28, 35, 42, 43, 44, 45, 46, 47, 48, 41, 34, 27, 20, 13, 6 };
            int[] l5yellow = { 30, 23, 22, 15, 8, 9, 10, 11, 18, 25, 32, 33 };
            int[] l5blue = { 29, 36, 37, 38, 39, 40 };
            int[] l5purple = { 2, 1, 0, 7, 14, 21 };
            int[] l5violet = { 3, 4, 5, 12, 19, 26 };

            int[] l6red = { 36, 29, 37 };
            int[] l6blue = { 32, 40, 33 };
            int[] l6orange = { 8, 15, 22, 23, 24, 25, 26 };
            int[] l6yellow = { 16, 17, 18 };
            int[] l6purple = { 39, 46, 47, 48, 41, 34, 27, 20, 13, 6, 5, 4, 3 };
            int[] l6violet = { 30, 31, 38, 45, 44, 43, 42, 35, 28, 21, 14, 7, 0, 1, 2, 9, 10, 11, 12, 19 };

            int[] l7red = { 24, 23, 30 };
            int[] l7blue = { 46, 47, 48, 41, 34 };
            int[] l7orange = { 44, 43, 42, 35, 28, 21, 14, 7, 8, 9, 10, 11, 12 };
            int[] l7yellow = { 37, 36, 29, 22, 15, 16, 17, 18, 19 };
            int[] l7purple = { 39, 40, 33 };
            int[] l7violet = { 0, 1, 2, 3, 4, 5, 6, 13, 20, 27, 26, 25, 32, 31, 38, 45 };

            int[] l8red = { 0, 9, 18, 27, 36, 45, 54, 63, 72, 73 };
            int[] l8blue = { 67, 68, 69 };
            int[] l8orange = { 46, 55, 64 };
            int[] l8yellow = { 24, 33, 32, 41, 50, 59, 60 };
            int[] l8purple = { 80, 71, 62, 53, 44, 35, 26, 17, 8, 7, 6, 5, 4, 3, 2, 11, 20, 29 };
            int[] l8violet = { 42, 51, 52, 61, 70, 79, 78, 77, 76, 75, 66, 57, 58, 49, 40, 31, 22, 23 };
            int[] l8green = { 48, 47, 56, 65, 74 };
            int[] l8silver = { 1, 10, 19, 28, 37, 38, 39, 30, 21, 12, 13, 14, 15, 16, 25, 34, 43 };

            int[] l9red = { 1, 0, 9, 18, 27, 36 };
            int[] l9blue = { 63, 72, 73, 74, 75, 76, 77, 78, 79, 80, 71, 62, 61, 60, 59 };
            int[] l9orange = { 24, 33, 42, 41, 40 };
            int[] l9yellow = { 22, 31, 30, 39, 48 };
            int[] l9purple = { 46, 37, 28, 19, 10, 11, 2, 3, 4, 5, 6, 15, 16, 25, 34, 43 };
            int[] l9violet = { 7, 8, 17, 26, 35, 44, 53, 52, 51, 50, 49 };
            int[] l9green = { 45, 54, 55, 64, 65, 66 };
            int[] l9silver = { 32, 23, 14, 13, 12, 21, 20, 29, 38, 47, 56, 57, 58, 67, 68, 69, 70 };

            System.out.println("check");

            switch (currlevel) {
                case 1: {
                    for (int i : l1red) {
                        System.out.println(tiles[i].getLabel());
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("check");
                            System.out.println("red error " + i);
                            displaymsg("red");
                        }
                    }

                    for (int i : l1yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow");
                        }
                    }

                    for (int i : l1orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange");
                        }
                    }

                    for (int i : l1blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue");
                        }
                    }
                    break;
                }

                case 2: {
                    for (int i : l2red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("red error " + i);
                            displaymsg("red");
                        }
                    }

                    for (int i : l2yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow");
                        }
                    }

                    for (int i : l2orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange");
                        }
                    }

                    for (int i : l2blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue");
                        }
                    }

                    break;
                }

                case 3: {
                    for (int i : l3red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("red error " + i);
                            displaymsg("red");
                        }
                    }

                    for (int i : l3yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow");
                        }
                    }

                    for (int i : l3orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange");
                        }
                    }

                    for (int i : l3blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue");
                        }
                    }

                    break;
                }

                case 4: {
                    for (int i : l4red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("red error " + i);
                            displaymsg("red");
                        }
                    }

                    for (int i : l4yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow");
                        }
                    }

                    for (int i : l4orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange");
                        }
                    }

                    for (int i : l4blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue");
                        }
                    }

                    break;
                }

                case 5: {
                    for (int i : l5red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("check");
                            System.out.println("red error " + i);
                            displaymsg("red");
                        }
                    }

                    for (int i : l5yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow");
                        }
                    }

                    for (int i : l5orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange");
                        }
                    }

                    for (int i : l5blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue");
                        }
                    }

                    for (int i : l5purple) {
                        if (!(tiles[i].getLabel() == "occupiedPURPLE" || tiles[i].getLabel() == "fixedP"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("PURPLE error");
                            displaymsg("purple");
                        }
                    }
                    for (int i : l5violet) {
                        if (!(tiles[i].getLabel() == "occupiedVIOLET" || tiles[i].getLabel() == "fixedV"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("VIOLET error");
                            displaymsg("violet");
                        }
                    }
                    break;
                }

                case 6: {
                    for (int i : l6red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("check");
                            displaymsg("red" + i);
                        }
                    }

                    for (int i : l6yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow" + i);
                        }
                    }

                    for (int i : l6orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange" + i);
                        }
                    }

                    for (int i : l6blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue" + i);
                        }
                    }

                    for (int i : l6purple) {
                        if (!(tiles[i].getLabel() == "occupiedPURPLE" || tiles[i].getLabel() == "fixedP"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("PURPLE error");
                            displaymsg("purple" + i);
                        }
                    }
                    for (int i : l6violet) {
                        if (!(tiles[i].getLabel() == "occupiedVIOLET" || tiles[i].getLabel() == "fixedV"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("VIOLET error");
                            displaymsg("violet" + i);
                        }
                    }

                    break;
                }

                case 7: {
                    for (int i : l7red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("check");
                            System.out.println("red error " + i);
                            displaymsg("red");
                        }
                    }

                    for (int i : l7yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow");
                        }
                    }

                    for (int i : l7orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange");
                        }
                    }

                    for (int i : l7blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue");
                        }
                    }

                    for (int i : l7purple) {
                        if (!(tiles[i].getLabel() == "occupiedPURPLE" || tiles[i].getLabel() == "fixedP"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("PURPLE error");
                            displaymsg("purple");
                        }
                    }
                    for (int i : l7violet) {
                        if (!(tiles[i].getLabel() == "occupiedVIOLET" || tiles[i].getLabel() == "fixedV"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("VIOLET error");
                            displaymsg("violet");
                        }
                    }
                    break;
                }

                case 8: {
                    for (int i : l8red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("check");
                            System.out.println("red error");
                            displaymsg("red" + i);
                            break;
                        }
                    }

                    for (int i : l8yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow" + i);
                        }
                    }

                    for (int i : l8orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange" + i);
                        }
                    }

                    for (int i : l8blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue" + i);
                        }
                    }

                    for (int i : l8purple) {
                        if (!(tiles[i].getLabel() == "occupiedPURPLE" || tiles[i].getLabel() == "fixedP"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("PURPLE error");
                            displaymsg("purple" + i);
                        }
                    }
                    for (int i : l8violet) {
                        if (!(tiles[i].getLabel() == "occupiedVIOLET" || tiles[i].getLabel() == "fixedV"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("VIOLET error");
                            displaymsg("violet" + i);
                        }
                    }
                    for (int i : l8green) {
                        if (!(tiles[i].getLabel() == "occupiedGREEN" || tiles[i].getLabel() == "fixedG"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("GREEN error");
                            displaymsg("green" + i);
                        }
                    }
                    for (int i : l8silver) {
                        if (!(tiles[i].getLabel() == "occupiedSILVER" || tiles[i].getLabel() == "fixedS"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("SILVER error");
                            displaymsg("silver" + i);
                        }
                    }
                    break;
                }

                case 9: {
                    for (int i : l9red) {
                        if (!(tiles[i].getLabel() == "occupiedRED" || tiles[i].getLabel() == "fixedR"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("check");
                            System.out.println("red error");
                            displaymsg("red" + i);
                            break;
                        }
                    }

                    for (int i : l9yellow) {
                        if (!(tiles[i].getLabel() == "occupiedYELLOW" || tiles[i].getLabel() == "fixedY"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("yellow error");
                            displaymsg("yellow" + i);
                        }
                    }

                    for (int i : l9orange) {
                        if (!(tiles[i].getLabel() == "occupiedORANGE" || tiles[i].getLabel() == "fixedO"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("orange error");
                            displaymsg("orange" + i);
                        }
                    }

                    for (int i : l9blue) {
                        if (!(tiles[i].getLabel() == "occupiedBLUE" || tiles[i].getLabel() == "fixedB"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("blue error");
                            displaymsg("blue" + i);
                        }
                    }

                    for (int i : l9purple) {
                        if (!(tiles[i].getLabel() == "occupiedPURPLE" || tiles[i].getLabel() == "fixedP"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("PURPLE error");
                            displaymsg("purple" + i);
                        }
                    }
                    for (int i : l9violet) {
                        if (!(tiles[i].getLabel() == "occupiedVIOLET" || tiles[i].getLabel() == "fixedV"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("VIOLET error");
                            displaymsg("violet" + i);
                        }
                    }
                    for (int i : l9green) {
                        if (!(tiles[i].getLabel() == "occupiedGREEN" || tiles[i].getLabel() == "fixedG"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("GREEN error");
                            displaymsg("green" + i);
                        }
                    }
                    for (int i : l9silver) {
                        if (!(tiles[i].getLabel() == "occupiedSILVER" || tiles[i].getLabel() == "fixedS"
                                || tiles[i].getLabel() == "")) {
                            System.out.println("SILVER error");
                            displaymsg("silver" + i);
                        }
                    }

                    break;
                }

                case 10: {

                }

                    break;
                default:
                    System.out.println("no level match " + currlevel);
                    break;
            }

            // level complete check
            if ((bluejoint == true && redjoint == true && yellowjoint == true && orangejoint == true
                    && (currlevel <= 4)) ||
                    (bluejoint == true && redjoint == true && yellowjoint == true && orangejoint == true
                            && purplejoint == true && violetjoint == true && (currlevel > 4 && currlevel < 8))
                    ||
                    (bluejoint == true && redjoint == true && yellowjoint == true && orangejoint == true
                            && purplejoint == true && violetjoint == true && greenjoint == true && silverjoint == true
                            && (currlevel > 7 && currlevel < 10))) {
                Object[] options1 = { "PLAY AGAIN", "NEXT LEVEL", "QUIT" };
                JPanel panel = new JPanel();
                panel.add(new JLabel("Level " + currlevel + " Completed"));
                int result = JOptionPane.showOptionDialog(null, panel, "ALERT",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options1, null);

                if (result == JOptionPane.YES_OPTION) {
                    reset();
                } else if (result == JOptionPane.NO_OPTION || result == JOptionPane.DEFAULT_OPTION) {
                    currlevel++;
                    System.out.println("current level" + currlevel);
                    switch (currlevel) {
                        case 1:
                            level1();
                            card.next(ps);
                            break;
                        case 2:
                            level2();
                            card.next(ps);
                            break;
                        case 3:
                            level3();
                            card.next(ps);
                            break;
                        case 4:
                            level4();
                            card.next(ps);
                            break;
                        case 5:
                            level5();
                            card.next(ps);
                            break;
                        case 6:
                            level6();
                            card.next(ps);
                            break;
                        case 7:
                            level7();
                            card.next(ps);
                            break;
                        case 8:
                            level8();
                            card.next(ps);
                            break;
                        case 9:
                            level9();
                            card.next(ps);
                            break;
                        case 10:
                            ending();
                            card.next(ps);
                            break;
                        default:
                            System.out.println("ERROR");
                            System.out.println(currlevel);
                            break;
                    }
                } else if (result == JOptionPane.CANCEL_OPTION) {
                    dispose();
                }
            }

        }

    }

    public void resetRED() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedRED") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetSILVER() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedSILVER") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetGREEN() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedGREEN") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetTEAL() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedTEAL") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetVIOLET() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }

        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedVIOLET") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetPURPLE() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedPURPLE") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetPINK() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedPINK") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetBLUE() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedBLUE") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetYELLOW() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedYELLOW") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void resetORANGE() {
        int j = 0;
        if (currlevel > 4 && currlevel < 8) {
            j = 49;
        } else if (currlevel > 7 && currlevel < 11) {
            j = 81;
        } else {
            j = 25;
        }
        for (int i = 0; i < j; i++) {
            if (tiles[i].getLabel() == "occupiedORANGE") {
                tiles[i].setBackground(Color.white);
                tiles[i].setLabel("");
            }
        }
    }

    public void reset() {
        System.out.println("current level is" + currlevel);
        switch (currlevel) {
            case 1:
                l1.removeAll();
                level1();
                revalidate();
                break;
            case 2:
                l2.removeAll();
                level2();
                revalidate();
                break;
            case 3:
                l3.removeAll();
                level3();
                revalidate();
                break;
            case 4:
                l4.removeAll();
                level4();
                revalidate();
                break;
            case 5:
                l5.removeAll();
                level5();
                revalidate();
                break;
            case 6:
                l6.removeAll();
                level6();
                revalidate();
                break;
            case 7:
                l7.removeAll();
                level7();
                revalidate();
                break;
            case 8:
                l8.removeAll();
                level8();
                revalidate();
                break;
            case 9:
                l9.removeAll();
                level9();
                revalidate();
                break;
            default:
                break;
        }
    }

    public void ending() {
        currlevel = 11;
        System.out.println("ending entered");
        Label msg = new Label("GAME COMPLETE ");

        msg.setFont(defaultf);
        msg.setForeground(Color.WHITE);
        ending.add(msg);
        levelLable.setText("END");
        next.setVisible(false);
        reset.setVisible(false);
        prev.setVisible(false);
    }

   

    public void level9() {
        currlevel = 9;
        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;
        purpleclickedS = false;
        violetclickedS = false;
        greenclickedS = false;
        silverclickedS = false;
        tealclickedS = false;

        redclickedE = false;
        blueclickedE = false;
        orangeclickedE = false;
        yellowclickedE = false;
        purpleclickedE = false;
        violetclickedE = false;
        greenclickedE = false;
        silverclickedE = false;
        tealclickedE = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;
        purplejoint = false;
        violetjoint = false;
        greenjoint = false;
        silverjoint = false;
        tealjoint = false;

        redS = 1;
        redE = 36;
        blueS = 63;
        blueE = 59;
        orangeS = 40;
        orangeE = 24;
        yellowS = 22;
        yellowE = 48;
        purpleS = 46;
        purpleE = 43;
        violetS = 49;
        violetE = 7;
        greenS = 45;
        greenE = 66;
        silverS = 32;
        silverE = 70;
        // tealS = 00;
        // tealE = 00;

        System.out.println("level 9 called");
        levelLable.setText("LEVEL 9");

        // initializing tiles as button
        for (int i = 0; i < 81; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level8 panel
        for (int i = 0; i < 81; i++) {
            l9.add(tiles[i]);
        }
        for (int i = 0; i < 81; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
            // tiles[i].setLabel(Integer.toString(i));
        }

        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);
        tiles[yellowS].setBackground(Color.yellow);
        tiles[yellowE].setBackground(Color.yellow);
        tiles[orangeS].setBackground(Color.orange);
        tiles[orangeE].setBackground(Color.orange);
        tiles[purpleS].setBackground(new Color(192, 0, 255));
        tiles[purpleE].setBackground(new Color(192, 0, 255));
        tiles[violetS].setBackground(new Color(143, 0, 255));
        tiles[violetE].setBackground(new Color(143, 0, 255));

        tiles[greenS].setBackground(Color.green);
        tiles[greenE].setBackground(Color.green);
        tiles[silverS].setBackground(new Color(192, 192, 192));
        tiles[silverE].setBackground(new Color(192, 192, 192));
        // tiles[tealS].setBackground(new Color(143, 0, 255));
        // tiles[tealE].setBackground(new Color(143, 0, 255));

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[yellowS].setForeground(Color.yellow);
        tiles[yellowE].setForeground(Color.yellow);
        tiles[orangeS].setForeground(Color.orange);
        tiles[orangeE].setForeground(Color.orange);
        tiles[purpleS].setForeground(new Color(192, 0, 255));
        tiles[purpleE].setForeground(new Color(192, 0, 255));
        tiles[violetS].setForeground(new Color(143, 0, 255));
        tiles[violetE].setForeground(new Color(143, 0, 255));

        tiles[greenS].setForeground(Color.green);
        tiles[greenE].setForeground(Color.green);
        tiles[silverS].setForeground(new Color(192, 192, 192));
        tiles[silverE].setForeground(new Color(192, 192, 192));
        // tiles[tealS].setForeground(new Color(143, 0, 255));
        // tiles[tealE].setForeground(new Color(143, 0, 255));

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowS].setLabel("fixedY");
        tiles[yellowE].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");
        tiles[purpleS].setLabel("fixedP");
        tiles[purpleE].setLabel("fixedP");
        tiles[violetS].setLabel("fixedV");
        tiles[violetE].setLabel("fixedV");

        tiles[greenS].setLabel("fixedG");
        tiles[greenE].setLabel("fixedG");
        tiles[silverS].setLabel("fixedS");
        tiles[silverE].setLabel("fixedS");
        // tiles[tealS].setLabel("fixedT");
        // tiles[tealE].setLabel("fixedT");
    }

    public void level8() {
        currlevel = 8;
        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;
        purpleclickedS = false;
        violetclickedS = false;
        greenclickedS = false;
        silverclickedS = false;
        tealclickedS = false;

        redclickedE = false;
        blueclickedE = false;
        orangeclickedE = false;
        yellowclickedE = false;
        purpleclickedE = false;
        violetclickedE = false;
        greenclickedE = false;
        silverclickedE = false;
        tealclickedE = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;
        purplejoint = false;
        violetjoint = false;
        greenjoint = false;
        silverjoint = false;
        tealjoint = false;

        redS = 0;
        redE = 73;
        blueS = 67;
        blueE = 69;
        orangeS = 64;
        orangeE = 46;
        yellowS = 24;
        yellowE = 60;
        purpleS = 80;
        purpleE = 29;
        violetS = 42;
        violetE = 23;
        greenS = 48;
        greenE = 74;
        silverS = 1;
        silverE = 43;
        // tealS = 00;
        // tealE = 00;

        System.out.println("level 8 called");
        levelLable.setText("LEVEL 8");

        // initializing tiles as button
        for (int i = 0; i < 81; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level8 panel
        for (int i = 0; i < 81; i++) {
            l8.add(tiles[i]);
        }
        for (int i = 0; i < 81; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
            // tiles[i].setLabel(Integer.toString(i));
        }

        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);
        tiles[yellowS].setBackground(Color.yellow);
        tiles[yellowE].setBackground(Color.yellow);
        tiles[orangeS].setBackground(Color.orange);
        tiles[orangeE].setBackground(Color.orange);
        tiles[purpleS].setBackground(new Color(192, 0, 255));
        tiles[purpleE].setBackground(new Color(192, 0, 255));
        tiles[violetS].setBackground(new Color(143, 0, 255));
        tiles[violetE].setBackground(new Color(143, 0, 255));

        tiles[greenS].setBackground(Color.green);
        tiles[greenE].setBackground(Color.green);
        tiles[silverS].setBackground(new Color(192, 192, 192));
        tiles[silverE].setBackground(new Color(192, 192, 192));
        // tiles[tealS].setBackground(new Color(143, 0, 255));
        // tiles[tealE].setBackground(new Color(143, 0, 255));

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[yellowS].setForeground(Color.yellow);
        tiles[yellowE].setForeground(Color.yellow);
        tiles[orangeS].setForeground(Color.orange);
        tiles[orangeE].setForeground(Color.orange);
        tiles[purpleS].setForeground(new Color(192, 0, 255));
        tiles[purpleE].setForeground(new Color(192, 0, 255));
        tiles[violetS].setForeground(new Color(143, 0, 255));
        tiles[violetE].setForeground(new Color(143, 0, 255));

        tiles[greenS].setForeground(Color.green);
        tiles[greenE].setForeground(Color.green);
        tiles[silverS].setForeground(new Color(192, 192, 192));
        tiles[silverE].setForeground(new Color(192, 192, 192));
        // tiles[tealS].setForeground(new Color(143, 0, 255));
        // tiles[tealE].setForeground(new Color(143, 0, 255));

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowS].setLabel("fixedY");
        tiles[yellowE].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");
        tiles[purpleS].setLabel("fixedP");
        tiles[purpleE].setLabel("fixedP");
        tiles[violetS].setLabel("fixedV");
        tiles[violetE].setLabel("fixedV");

        tiles[greenS].setLabel("fixedG");
        tiles[greenE].setLabel("fixedG");
        tiles[silverS].setLabel("fixedS");
        tiles[silverE].setLabel("fixedS");
        // tiles[tealS].setLabel("fixedT");
        // tiles[tealE].setLabel("fixedT");
    }

    public void level7() {
        currlevel = 7;
        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;
        purpleclickedS = false;
        violetclickedS = false;

        redclickedE = false;
        blueclickedE = false;
        orangeclickedE = false;
        yellowclickedE = false;
        purpleclickedE = false;
        violetclickedE = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;
        purplejoint = false;
        violetjoint = false;

        redS = 24;
        redE = 30;
        blueS = 46;
        blueE = 34;
        orangeS = 44;
        orangeE = 12;
        yellowS = 37;
        yellowE = 19;
        purpleS = 39;
        purpleE = 33;
        violetS = 0;
        violetE = 45;

        System.out.println("level 7 called");
        levelLable.setText("LEVEL 7");

        // initializing tiles as button
        for (int i = 0; i < 49; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level1 panel
        for (int i = 0; i < 49; i++) {
            l7.add(tiles[i]);
        }
        for (int i = 0; i < 49; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
        }

        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);
        tiles[yellowS].setBackground(Color.yellow);
        tiles[yellowE].setBackground(Color.yellow);
        tiles[orangeS].setBackground(Color.orange);
        tiles[orangeE].setBackground(Color.orange);

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[yellowS].setForeground(Color.yellow);
        tiles[yellowE].setForeground(Color.yellow);
        tiles[orangeS].setForeground(Color.orange);
        tiles[orangeE].setForeground(Color.orange);
        tiles[purpleS].setForeground(new Color(192, 0, 255));
        tiles[purpleE].setForeground(new Color(192, 0, 255));
        tiles[violetS].setForeground(new Color(143, 0, 255));
        tiles[violetE].setForeground(new Color(143, 0, 255));
        tiles[purpleS].setBackground(new Color(192, 0, 255));
        tiles[purpleE].setBackground(new Color(192, 0, 255));
        tiles[violetS].setBackground(new Color(143, 0, 255));
        tiles[violetE].setBackground(new Color(143, 0, 255));

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowS].setLabel("fixedY");
        tiles[yellowE].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");
        tiles[purpleS].setLabel("fixedP");
        tiles[purpleE].setLabel("fixedP");
        tiles[violetS].setLabel("fixedV");
        tiles[violetE].setLabel("fixedV");
    }

    public void level6() {
        currlevel = 6;

        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;
        purpleclickedS = false;
        violetclickedS = false;

        redclickedE = false;
        blueclickedE = false;
        orangeclickedE = false;
        yellowclickedE = false;
        purpleclickedE = false;
        violetclickedE = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;
        purplejoint = false;
        violetjoint = false;

        blueS = 32;
        blueE = 40;
        redS = 37;
        redE = 29;
        yellowS = 16;
        yellowE = 18;
        orangeS = 26;
        orangeE = 8;
        purpleS = 3;
        purpleE = 39;
        violetS = 30;
        violetE = 19;

        System.out.println("level 6 called");
        levelLable.setText("LEVEL 6");

        // initializing tiles as button
        for (int i = 0; i < 49; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level1 panel
        for (int i = 0; i < 49; i++) {
            l6.add(tiles[i]);
        }
        for (int i = 0; i < 49; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
        }

        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);
        tiles[yellowS].setBackground(Color.yellow);
        tiles[yellowE].setBackground(Color.yellow);
        tiles[orangeS].setBackground(Color.orange);
        tiles[orangeE].setBackground(Color.orange);

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[yellowS].setForeground(Color.yellow);
        tiles[yellowE].setForeground(Color.yellow);
        tiles[orangeS].setForeground(Color.orange);
        tiles[orangeE].setForeground(Color.orange);
        tiles[purpleS].setForeground(new Color(192, 0, 255));
        tiles[purpleE].setForeground(new Color(192, 0, 255));
        tiles[violetS].setForeground(new Color(143, 0, 255));
        tiles[violetE].setForeground(new Color(143, 0, 255));
        tiles[purpleS].setBackground(new Color(192, 0, 255));
        tiles[purpleE].setBackground(new Color(192, 0, 255));
        tiles[violetS].setBackground(new Color(143, 0, 255));
        tiles[violetE].setBackground(new Color(143, 0, 255));

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowS].setLabel("fixedY");
        tiles[yellowE].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");
        tiles[purpleS].setLabel("fixedP");
        tiles[purpleE].setLabel("fixedP");
        tiles[violetS].setLabel("fixedV");
        tiles[violetE].setLabel("fixedV");
    }

    public void level5() {
        currlevel = 5;

        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;
        purpleclickedS = false;
        violetclickedS = false;

        redclickedE = false;
        blueclickedE = false;
        orangeclickedE = false;
        yellowclickedE = false;
        purpleclickedE = false;
        violetclickedE = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;
        purplejoint = false;
        violetjoint = false;

        blueS = 29;
        blueE = 40;
        redS = 16;
        redE = 31;
        yellowS = 33;
        yellowE = 30;
        orangeS = 28;
        orangeE = 6;
        purpleS = 2;
        purpleE = 21;
        violetS = 3;
        violetE = 26;

        System.out.println("level 5 called");
        levelLable.setText("LEVEL 5");

        // initializing tiles as button
        for (int i = 0; i < 49; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level1 panel
        for (int i = 0; i < 49; i++) {
            l5.add(tiles[i]);
        }
        for (int i = 0; i < 49; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
        }

        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);
        tiles[yellowS].setBackground(Color.yellow);
        tiles[yellowE].setBackground(Color.yellow);
        tiles[orangeS].setBackground(Color.orange);
        tiles[orangeE].setBackground(Color.orange);

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[yellowS].setForeground(Color.yellow);
        tiles[yellowE].setForeground(Color.yellow);
        tiles[orangeS].setForeground(Color.orange);
        tiles[orangeE].setForeground(Color.orange);
        tiles[purpleS].setForeground(new Color(192, 0, 255));
        tiles[purpleE].setForeground(new Color(192, 0, 255));
        tiles[violetS].setForeground(new Color(143, 0, 255));
        tiles[violetE].setForeground(new Color(143, 0, 255));
        tiles[purpleS].setBackground(new Color(192, 0, 255));
        tiles[purpleE].setBackground(new Color(192, 0, 255));
        tiles[violetS].setBackground(new Color(143, 0, 255));
        tiles[violetE].setBackground(new Color(143, 0, 255));

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowS].setLabel("fixedY");
        tiles[yellowE].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");
        tiles[purpleS].setLabel("fixedP");
        tiles[purpleE].setLabel("fixedP");
        tiles[violetS].setLabel("fixedV");
        tiles[violetE].setLabel("fixedV");
    }

    public void level4() {
        currlevel = 4;
        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;

        blueS = 12;
        blueE = 22;
        redS = 6;
        redE = 17;
        yellowS = 4;
        yellowE = 21;
        orangeE = 7;
        orangeS = 24;

        System.out.println("level 4 called");
        levelLable.setText("LEVEL 4");

        // initializing tiles as button
        for (int i = 0; i < 25; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level1 panel
        for (int i = 0; i < 25; i++) {
            l4.add(tiles[i]);
        }
        for (int i = 0; i < 25; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
        }
        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[orangeS].setBackground(Color.ORANGE);
        tiles[orangeE].setBackground(Color.ORANGE);
        tiles[yellowS].setBackground(Color.YELLOW);
        tiles[yellowE].setBackground(Color.YELLOW);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[orangeS].setForeground(Color.ORANGE);
        tiles[orangeE].setForeground(Color.ORANGE);
        tiles[yellowS].setForeground(Color.YELLOW);
        tiles[yellowE].setForeground(Color.YELLOW);

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowE].setLabel("fixedY");
        tiles[yellowS].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");
    }

    public void level3() {
        currlevel = 3;
        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;

        blueS = 18;
        blueE = 12;
        redS = 23;
        redE = 4;
        yellowS = 20;
        yellowE = 3;
        orangeE = 13;
        orangeS = 24;

        System.out.println("level 3 called");
        levelLable.setText("LEVEL 3");

        // initializing tiles as button
        for (int i = 0; i < 25; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level1 panel
        for (int i = 0; i < 25; i++) {
            l3.add(tiles[i]);
        }
        for (int i = 0; i < 25; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
        }
        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[orangeS].setBackground(Color.ORANGE);
        tiles[orangeE].setBackground(Color.ORANGE);
        tiles[yellowS].setBackground(Color.YELLOW);
        tiles[yellowE].setBackground(Color.YELLOW);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[orangeS].setForeground(Color.ORANGE);
        tiles[orangeE].setForeground(Color.ORANGE);
        tiles[yellowS].setForeground(Color.YELLOW);
        tiles[yellowE].setForeground(Color.YELLOW);

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowE].setLabel("fixedY");
        tiles[yellowS].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");
    }

    public void level2() {
        currlevel = 2;
        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;

        blueS = 5;
        blueE = 21;
        redS = 12;
        redE = 14;
        yellowS = 0;
        yellowE = 24;
        orangeE = 8;
        orangeS = 19;

        System.out.println("level 2 called");
        levelLable.setText("LEVEL 2");

        // initializing tiles as button
        for (int i = 0; i < 25; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level1 panel
        for (int i = 0; i < 25; i++) {
            l2.add(tiles[i]);
        }
        for (int i = 0; i < 25; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
            // tiles[i].setLabel(Integer.toString(i));

        }

        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[orangeS].setBackground(Color.ORANGE);
        tiles[orangeE].setBackground(Color.ORANGE);
        tiles[yellowS].setBackground(Color.YELLOW);
        tiles[yellowE].setBackground(Color.YELLOW);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[orangeS].setForeground(Color.ORANGE);
        tiles[orangeE].setForeground(Color.ORANGE);
        tiles[yellowS].setForeground(Color.YELLOW);
        tiles[yellowE].setForeground(Color.YELLOW);

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowE].setLabel("fixedY");
        tiles[yellowS].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");

    }

    public void level1() {
        currlevel = 1;
        redclickedS = false;
        blueclickedS = false;
        orangeclickedS = false;
        yellowclickedS = false;

        redjoint = false;
        bluejoint = false;
        orangejoint = false;
        yellowjoint = false;

        blueS = 5;
        blueE = 14;
        redS = 3;
        redE = 11;
        yellowE = 6;
        yellowS = 0;
        orangeE = 16;
        orangeS = 4;

        System.out.println("level 1 called");
        levelLable.setText("LEVEL 1");

        // initializing tiles as button
        for (int i = 0; i < 25; i++) {
            tiles[i] = new Button();
        }
        // adding tiles to level1 panel
        for (int i = 0; i < 25; i++) {
            l1.add(tiles[i]);
        }
        for (int i = 0; i < 25; i++) {
            tiles[i].addMouseListener(new mouseHandler());
            tiles[i].setBackground(Color.WHITE);
        }
        tiles[redS].setBackground(Color.RED);
        tiles[redE].setBackground(Color.RED);
        tiles[orangeS].setBackground(Color.ORANGE);
        tiles[orangeE].setBackground(Color.ORANGE);
        tiles[yellowS].setBackground(Color.YELLOW);
        tiles[yellowE].setBackground(Color.YELLOW);
        tiles[blueS].setBackground(Color.BLUE);
        tiles[blueE].setBackground(Color.BLUE);

        tiles[redS].setForeground(Color.RED);
        tiles[redE].setForeground(Color.RED);
        tiles[blueS].setForeground(Color.BLUE);
        tiles[blueE].setForeground(Color.BLUE);
        tiles[orangeS].setForeground(Color.ORANGE);
        tiles[orangeE].setForeground(Color.ORANGE);
        tiles[yellowS].setForeground(Color.YELLOW);
        tiles[yellowE].setForeground(Color.YELLOW);

        tiles[redS].setLabel("fixedR");
        tiles[redE].setLabel("fixedR");
        tiles[blueS].setLabel("fixedB");
        tiles[blueE].setLabel("fixedB");
        tiles[yellowE].setLabel("fixedY");
        tiles[yellowS].setLabel("fixedY");
        tiles[orangeS].setLabel("fixedO");
        tiles[orangeE].setLabel("fixedO");

    }

    class actionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Button temp = (Button) e.getSource();
            if (temp == start) {
                reset.setVisible(true);
                level1();
                card.next(ps);

            } else if (temp == reset) {
                reset();
            } else if (temp == next) {
                reset.setVisible(true);
                System.out.println("next button");
                currlevel++;
                System.out.println("current level" + currlevel);

                switch (currlevel) {
                    case 1:
                        level1();
                        card.next(ps);
                        break;
                    case 2:
                        level2();
                        card.next(ps);
                        break;
                    case 3:
                        level3();
                        card.next(ps);
                        break;
                    case 4:
                        level4();
                        card.next(ps);
                        break;
                    case 5:
                        level5();
                        card.next(ps);
                        break;
                    case 6:
                        level6();
                        card.next(ps);
                        break;
                    case 7:
                        level7();
                        card.next(ps);
                        break;
                    case 8:
                        level8();
                        card.next(ps);
                        break;
                    case 9:
                        level9();
                        card.next(ps);
                        break;
                    case 10:
                        ending();
                        card.next(ps);
                        break;
                    default:
                        System.out.println("ERROR");
                        System.out.println(currlevel);
                        break;
                }
                reset();

            } else if (temp == prev) {
                reset.setVisible(true);
                System.out.println("prev button");
                currlevel--;
                System.out.println("current level" + currlevel);

                switch (currlevel) {
                    case 1:
                        card.previous(ps);
                        level1();
                        break;
                    case 2:
                        card.previous(ps);
                        level2();
                        break;
                    case 3:
                        card.previous(ps);
                        level3();
                        break;
                    case 4:
                        card.previous(ps);
                        level4();
                        break;
                    case 5:
                        level5();
                        card.previous(ps);
                        break;
                    case 6:
                        level6();
                        card.previous(ps);
                        break;
                    case 7:
                        level7();
                        card.previous(ps);
                        break;
                    case 8:
                        level8();
                        card.previous(ps);
                        break;
                    case 9:
                        level9();
                        card.previous(ps);
                        break;
                    case 10:
                        ending();
                        card.previous(ps);
                        break;
                    default:
                        System.out.println("ERROR");
                        System.out.println(currlevel);
                        break;
                }
                reset();

            }
        }
    }

    public void displaymsg(String col) {
        Object[] options1 = { "PLAY AGAIN", "QUIT" };
        JPanel panel = new JPanel();
        panel.add(new JLabel(col + " Incorrect Move ,Try Again "));
        int result = JOptionPane.showOptionDialog(null, panel, "ALERT",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);

        if (result == JOptionPane.YES_OPTION) {
            System.out.println("play again clicked");
            reset();
        } else if (result == JOptionPane.NO_OPTION || result == JOptionPane.DEFAULT_OPTION) {
            System.out.println("disposed ");
            dispose();
        }
    }

    public static void main(String[] args) {
        Frame f = new connect();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}