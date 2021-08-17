import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class TopFiveDestinationList {
    private JButton button1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);

                //Added my name, course, and date as a clickable for my label and customization.
                topDestinationListFrame.getContentPane().add(new JButton("Jarod Timms - CS250 - 03/20/21"), BorderLayout.NORTH);

            }
        });
    }

    static class TopDestinationListFrame extends JFrame {
        private DefaultListModel listModel;

        public TopDestinationListFrame() {
            super("Top Five Destination List");

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(1280, 800);

            listModel = new DefaultListModel();
            //String variables to store photo credits
            String dest1 = "Photo: Michal Klajban, https://commons.wikimedia.org/wiki/File:Lake_Mystery,_Canterbury,_New_Zealand_05.jpg";
            String dest2 = "Photo: George. Edit: Muhammad Mahdi Karim, https://commons.wikimedia.org/wiki/File:Kohala_coast_at_the_Big_Island_of_Hawaii_from_the_air_levels.jpg";
            String dest3 = "Photo: Picasa, https://commons.wikimedia.org/wiki/File:Rocket_garden_-_Kennedy_Space_Center_-_Cape_Canaveral,_Florida_-_DSC02345.jpg";
            String dest4 = "Photo: Basile Morin, https://commons.wikimedia.org/wiki/File:Colorful_neon_street_signs_in_Kabukich%C5%8D,_Shinjuku,_Tokyo.jpg";
            String dest5 = "Photo: Mathieu Landretti, https://commons.wikimedia.org/wiki/File:Capitol_washington_dc.jpg";

            //All five locations are filled out based on the user story structure.
            addDestinationNameAndPicture("1. New Zealand (A diverse island ecosystem popular for tourists and film makers.) " +
                    dest1, new ImageIcon(getClass().getResource("/resources/newZealand.jpg")));
            addDestinationNameAndPicture("2. Hawaii, (A State in the United States composed of a chain of volcanic plume islands.) " +
                    dest2, new ImageIcon(getClass().getResource("/resources/hawaii.jpg")));
            addDestinationNameAndPicture("3. Merritt Island, Florida (Located on the eastern Florida coast and home to the Kennedy Space Center Visitor Center.) " +
                    dest3, new ImageIcon(getClass().getResource("/resources/miFlorida.jpg")));
            addDestinationNameAndPicture("4. Tokyo, Japan (Most well known city in Japan with a large tourist hub including shopping centers and recreational parks.) " +
                    dest4, new ImageIcon(getClass().getResource("/resources/tokyo.jpg")));
            addDestinationNameAndPicture("5. Washington, D.C. (Capital of the United States of America and home to the Smithsonian Museums.) " +
                    dest5, new ImageIcon(getClass().getResource("/resources/washingtonDC.jpg")));

            JList list = new JList(listModel);
            JScrollPane scrollPane = new JScrollPane(list);

            TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

            list.setCellRenderer(renderer);

            getContentPane().add(scrollPane, BorderLayout.CENTER);
        }

        private void addDestinationNameAndPicture(String text, Icon icon) {
            TextAndIcon tai = new TextAndIcon(text, icon);
            listModel.addElement(tai);
        }
    }

    static class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
        private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

        private Border insideBorder;

        public TextAndIconListCellRenderer() {
            this(0, 0, 0, 0);
        }

        public TextAndIconListCellRenderer(int padding) {
            this(padding, padding, padding, padding);
        }

        public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
            insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean hasFocus) {
            // The object from the combo box model MUST be a TopFiveDestinationList.TextAndIcon.
            TextAndIcon tai = (TextAndIcon) value;

            // Sets text and icon on 'this' JLabel.
            setText(tai.getText());
            setIcon(tai.getIcon());

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            Border outsideBorder;

            if (hasFocus) {
                outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
            } else {
                outsideBorder = NO_FOCUS_BORDER;
            }

            setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
            setComponentOrientation(list.getComponentOrientation());
            setEnabled(list.isEnabled());
            setFont(list.getFont());

            return this;
        }

        // The following methods are overridden to be empty for performance
        // reasons. If you want to understand better why, please read:
        //
        // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

        public void validate() {
        }

        public void invalidate() {
        }

        public void repaint() {
        }

        public void revalidate() {
        }

        public void repaint(long tm, int x, int y, int width, int height) {
        }

        public void repaint(Rectangle r) {
        }
    }

    static class TextAndIcon {
        private String text;
        private Icon icon;

        public TextAndIcon(String text, Icon icon) {
            this.text = text;
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public Icon getIcon() {
            return icon;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setIcon(Icon icon) {
            this.icon = icon;
        }
    }
}


