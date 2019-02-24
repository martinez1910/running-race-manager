using PI_Ev_2.logic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace PI_Ev_2.gui
{
   public partial class ItemForm : Window
    {
       private MyItem Item { get; set; }
       private bool Modifying;
       private int Pos;
       private int Errors = 0;
        
       public ItemForm()
       {
           InitializeComponent();
           MyInitializeComponent();
           Item = new MyItem();
           this.DataContext = Item;
       }

       public ItemForm(MyItem item, int pos)
       {
           InitializeComponent();
           MyInitializeComponent();
           Item = item;
           this.DataContext = Item;
           Modifying = true;
           Pos = pos;
       }

       private void MyInitializeComponent()
       {
           var types = new List<String>();
           types.Add("Bebida");
           types.Add("Comida");
           types.Add("Material Sanitario");
           foreach (String type in types)
           {
               var cbi = new ComboBoxItem();
               cbi.Content = type;
               cbType.Items.Add(cbi);
           }
       }


        private void BtnCancel_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnAccept_Click(object sender, RoutedEventArgs e)
        {
            if (txtName.Text.Equals(""))
            {
                MessageBox.Show("Debe introducir un nombre", "Error");
                return;
            }

            if (!Modifying)
                AddItem();
            else
                EditItem();             
        }

        private void AddItem()
        {
            if (!RepositoryImpl.GetInstance().AddItem(Item))
                MessageBox.Show("El material ya existe", "Error");
            else
                this.Close();
        }

        private void EditItem()
        {
            if (!RepositoryImpl.GetInstance().UpdateItem(Item, Pos))
                MessageBox.Show("El material ya existe", "Error");
            else
                this.Close();
        }

        private void Validation_Error(object sender, ValidationErrorEventArgs args)
        {
            if (args.Action == ValidationErrorEventAction.Added)
                Errors++;
            else
                Errors--;

            if (Errors == 0)
                btnAccept.IsEnabled = true;
            else
                btnAccept.IsEnabled = false;
        }
    }
}
