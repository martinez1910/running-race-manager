﻿using PI_Ev_2.logic;
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
    public partial class SupplyForm : Window
    {
        private Supply Supply { get; set; }
        private bool Modifying;
        private int Pos;

        public SupplyForm()
        {
            InitializeComponent();
            Supply = new Supply();
            this.DataContext = Supply;
            MyInitializeComponent();
        }
        public SupplyForm(Supply supply, int pos)
        {
            InitializeComponent();
            Supply = supply;
            this.DataContext = Supply;
            Modifying = true;
            Pos = pos;
            MyInitializeComponent();
        }

        private void MyInitializeComponent()
        {
            foreach(Race race in RepositoryImpl.GetInstance().GetRaces()){
                var cbi = new ComboBoxItem();
                cbi.Content = race;
                cbRace.Items.Add(race);
            }

            lvItems.ItemsSource = Supply.Items;

            //var lvi = new ListViewItem();
            //lvi.Content = item.ToString();
            //lvItems.Items.Add(lvi);
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
                AddSupply();
            else
                EditSupply(); 
        }

        private void AddSupply()
        {
            if (!RepositoryImpl.GetInstance().AddSupply(Supply))
                MessageBox.Show("El material ya existe", "Error");
            else
                this.Close();
        }

        private void EditSupply()
        {
            if (!RepositoryImpl.GetInstance().UpdateSupply(Supply, Pos))
                MessageBox.Show("El material ya existe", "Error");
            else
                this.Close();
        }

        private void btnAdd_Click(object sender, RoutedEventArgs e)
        {
            var window = new SupplyFormItemForm(Supply);
            window.ShowDialog();
        }
    }
}