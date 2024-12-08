/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package javafxapplication1;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;



/**
 *
 * @author hp
 */
public class  DButils
{

    public static void changescene(ActionEvent event , String fxmlFile,String title) throws IOException
    {
        Parent root=null;
        
           root = FXMLLoader.load(DButils.class.getResource(fxmlFile));
        
        
        Stage stage = (Stage) ((Node) event .getSource()).getScene().getWindow();
                stage.setTitle(title);
                stage.setScene(new Scene(root,800,600));
                stage.show();
                
                
   
    }
    public static void signUp(ActionEvent event , String username , String password,String Field,String Difficulty) throws SQLException, IOException
    {
         Connection connection = null;
         PreparedStatement psInsert = null;
         PreparedStatement psCheckUserExists=null;
         ResultSet resultSet = null;
         try
         {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root", "1234");
              psCheckUserExists=connection.prepareStatement("SELECT * FROM users WHERE username = ?");  
              psCheckUserExists.setString( 1, username);
              resultSet=psCheckUserExists.executeQuery();
              if(resultSet.isBeforeFirst())
              {
                  System.out.println("User Already Exist");
                  Alert alert;
                 alert = new Alert(Alert.AlertType.ERROR);
                 alert.setContentText("User Already Exist");
                 alert.show();
                 
              }
              else
              {
                psInsert = connection.prepareStatement("INSERT INTO users (username , password ,Field,Difficulty) VALUES (?,?,?,?)");
             
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.setString(3,Field);
                psInsert.setString(4,Difficulty);
                psInsert.executeUpdate();
                        if(Field.equals("IT") && Difficulty.equals("Beginner"))
                        {
                            changescene(event, "loginhua.fxml", "IT Beginner");
                        }
                  if(Field.equals("IT") && Difficulty.equals("Intermediate"))
                  {
                      changescene(event, "itinter.fxml", "IT Intermediate");
                  }
                  if(Field.equals("IT") && Difficulty.equals("Advanced"))
                  {
                      changescene(event, "itadv.fxml", "IT Advanced");
                  }

                  if(Field.equals("IOT") && Difficulty.equals("Beginner"))
                  {
                      changescene(event, "IOTbegin.fxml", "IOT Beginner");
                  }
                  if(Field.equals("IOT") && Difficulty.equals("Intermediate"))
                  {
                      changescene(event, "IOTinter.fxml", "IOT Intermediate");
                  }
                  if(Field.equals("IOT") && Difficulty.equals("Advanced"))
                  {
                      changescene(event, "IOTadv.fxml", "IOT Advanced");
                  }
                  if(Field.equals("Web") && Difficulty.equals("Beginner"))
                  {
                      changescene(event, "webbegin.fxml", "Web Beginner");
                  }
                  if(Field.equals("Web") && Difficulty.equals("Intermediate"))
                  {
                      changescene(event, "webinter.fxml", "Web Intermediate");
                  }
                  if(Field.equals("Web") && Difficulty.equals("Advanced"))
                  {
                      changescene(event, "webadv.fxml", "Web Advanced");
                  }


              }
         }catch (SQLException e)
         {
             e.printStackTrace();
         } finally{ 
             if(resultSet!=null)
             {try{
                 resultSet.close();
             }catch(SQLException e)
             {
                 e.printStackTrace();
             }
             }
             if(psCheckUserExists!=null)
             {
                 try
                 {
                     psCheckUserExists.close();
                 }catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
             }
             
             if(connection!=null)
             {
                 try
                 {
                     connection.close();
                 } catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
             }
         }
         
    }
    
    public static void logInUser(ActionEvent event , String username , String password  ) throws IOException
    {
           Connection connection = null;
           PreparedStatement preparedStatement = null;
           ResultSet resultSet = null;
           try
           {
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "1234");
               preparedStatement = connection.prepareStatement("SELECT password,Field,Difficulty FROM users WHERE username=?");
               preparedStatement.setString(1,username); 
               resultSet = preparedStatement.executeQuery();
               if(!resultSet.isBeforeFirst())
               {
                   System.out.println("User notfound in database");
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setContentText("Provided credentials incorrect");
                    alert.show();
                    
               }
               else
               {
                   while(resultSet.next())
                   {
                     String retrievedPassword = resultSet.getString  ("password");
                     String retrievedField = resultSet.getString("Field");
                     String retrievedDifficulty = resultSet.getString("Difficulty");
                     if(retrievedPassword.equals(password)) {
                                if(retrievedField.equals("IT") && retrievedDifficulty.equals("Beginner"))
                                {
                                    changescene(event, "loginhua.fxml", "IT Beginner");
                                }
                         if(retrievedField.equals("IT") && retrievedDifficulty.equals("Intermediate"))
                         {
                             changescene(event, "itinter.fxml", "IT Intermediate");
                         }

                         if(retrievedField.equals("IT") && retrievedDifficulty.equals("Advanced"))
                         {
                             changescene(event, "itadv.fxml", "IT Advanced");
                         }

                         if(retrievedField.equals("IOT") && retrievedDifficulty.equals("Beginner"))
                         {
                             changescene(event, "IOTbegin.fxml", "IOT Beginner");
                         }
                         if(retrievedField.equals("IOT") && retrievedDifficulty.equals("Intermediate"))
                         {
                             changescene(event, "IOTinter.fxml", "IOT Intermediate");
                         }
                         if(retrievedField.equals("IOT") && retrievedDifficulty.equals("Advanced"))
                         {
                             changescene(event, "IOTadv.fxml", "IOT Advanced");
                         }
                         if(retrievedField.equals("Web") && retrievedDifficulty.equals("Beginner"))
                         {
                             changescene(event, "webbegin.fxml", "Web Beginner");
                         }
                         if(retrievedField.equals("Web") && retrievedDifficulty.equals("Intermediate"))
                         {
                             changescene(event, "webinter.fxml", "Web Intermediate");
                         }
                         if(retrievedField.equals("Web") && retrievedDifficulty.equals("Advanced"))
                         {
                             changescene(event, "webadv.fxml", "Web Advanced");
                         }






                     }
                     else{
                         System.out.println("Password do not match");
                         Alert alert = new Alert(Alert.AlertType.ERROR);
                         alert.setContentText("The provided credentials are incorrect");
                         alert.show();
                     }
                   }
                   
               }
           }catch(SQLException e)
           {
               e.printStackTrace();
           }finally{
               if(resultSet != null)
               {
                   try {
                       resultSet.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
               if(preparedStatement != null)
               {
                   try
                   {
                       preparedStatement.close();
                       
                   }catch(SQLException e)
                   {
                       e.printStackTrace();
                   }
               }
               if(connection != null)
               {
                   try
                   {
                       connection.close();
                   }
                   catch(SQLException e)
                   {
                       e.printStackTrace();
                   }
               }
           }
    }
    public static String coursedataname(int course_id,String table)

    {
        String s1="jdbc:mysql://localhost:3306/javaproject";
        String s2 = "root";
        String s3="1234";
        Connection connection=null;
        ResultSet resultSet = null;
        String sql = "SELECT coursename, courseurl, type FROM " + table + " WHERE course_id=?";
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(s1,s2,s3);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,course_id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

                String courseName = resultSet.getString("coursename");

            return courseName;










        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            if(resultSet != null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null)
            {
                try
                {
                    preparedStatement.close();

                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String coursedatatype(int course_id,String table)

    {
        String s1="jdbc:mysql://localhost:3306/javaproject";
        String s2 = "root";
        String s3="1234";
        Connection connection=null;
        ResultSet resultSet = null;
        String sql = "SELECT coursename, courseurl, type FROM " + table + " WHERE course_id=?";
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(s1,s2,s3);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,course_id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            String courseName = resultSet.getString("coursename");
            String courseUrl = resultSet.getString("courseurl");
            String courseType = resultSet.getString("type");
            return courseType;










        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            if(resultSet != null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null)
            {
                try
                {
                    preparedStatement.close();

                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String coursedataurl(int course_id,String table)

    {
        String s1="jdbc:mysql://localhost:3306/javaproject";
        String s2 = "root";
        String s3="1234";
        Connection connection=null;
        ResultSet resultSet = null;
        String sql = "SELECT coursename, courseurl, type FROM " + table + " WHERE course_id=?";
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(s1,s2,s3);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,course_id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            String courseName = resultSet.getString("coursename");
            String courseUrl = resultSet.getString("courseurl");
            String courseType = resultSet.getString("type");
            return courseUrl;










        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            if(resultSet != null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null)
            {
                try
                {
                    preparedStatement.close();

                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }



}
