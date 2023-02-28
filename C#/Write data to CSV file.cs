using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;   // use for converting to csv
using System.Collections;

namespace Bai3
{
    public partial class CSVView : Form
    {
        private ArrayList list;

        public CSVView()
        {
            InitializeComponent();
            this.list = new ArrayList();
        }

        public ArrayList List
        {
            get
            {
                return list;
            }

            set
            {
                list = value;
            }
        }

        public void CreateTableView()
        {
            DataTable dt = new DataTable();

            // tao 4 cot header
            dt.Columns.AddRange(new DataColumn[4]
            {
                new DataColumn("Name", typeof(string)),
                new DataColumn("Birth", typeof(DateTime)),
                new DataColumn("Gender",typeof(string)),
                new DataColumn("Born in",typeof(string))
            });

            // them du lieu vao cot
            foreach (Student student in list)
                dt.Rows.Add(student.Name, student.Birth, student.Gender, student.BornIn);

            // chuyen data tu DataTable vao GridView
            this.dataGridView1.DataSource = dt;
        }

        private void btnExportCSV_Click(object sender, EventArgs e)
        {
            // tao file csv la cac chuoi duoc ngan cach nhau boi dau ','
            string csv = string.Empty;

            foreach (DataGridViewColumn column in dataGridView1.Columns)
                csv += column.HeaderText + ',';

            // them 1 dong moi trong csv (xuong hang)
            csv += "\r\n";

            // them du lieu vao dong
            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                foreach (DataGridViewCell cell in row.Cells)
                {
                    //Add the Data rows.
                    csv += cell.Value + ",";
                }
                    
                //Add new line.
                csv += "\r\n";
            }

            //Exporting to CSV.
            //string folderPath = "C:\\CSV\\";
            //File.WriteAllText(folderPath + "DataGridViewExport.csv", csv);

            //Exporting to CSV.
            //File.WriteAllText("..\\..\\StudentList.csv", csv);

            File.WriteAllText("..\\..\\StudentList.csv", csv, Encoding.UTF8);


            MessageBox.Show("Convert to CSV file success !");
        }
    }
}
