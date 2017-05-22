package rocket.app.view;

import java.text.DecimalFormat;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {
	
	ObservableList<Integer> cmbTermlist = FXCollections.observableArrayList(15,30);
	
	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgagePayment;
	@FXML TextField txtIncome;
	@FXML TextField txtExpenses;
	@FXML TextField txtHouseCost;
	@FXML TextField txtDownPayment;

	
	@FXML Label lblIncome;
	@FXML Label lblExpenses;
	@FXML Label lblCreditScore;
	@FXML Label lblHouseCost;
	@FXML Label lblTerm;
	@FXML Label lblMortgagePayment;
	@FXML Label lblDownPayment;
	
	@FXML ComboBox<Integer> cmbTerm;
	@FXML Button buttonCalculatePayment;
	
	private TextField txtNew;
	
	private MainApp mainApp;
	


	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{

		double PITI1 = LoanRequest.getdIncome()*0.28; 
		double PITI2 = LoanRequest.getdIncome()*0.36 - LoanRequest.getdExpenses();
		
		if(PITI1>PITI2){
				if(lRequest.getdPayment() < PITI2){
				
						lblMortgagePayment.setText("The cost is: " + String.format("%1$,.2f", Math.round(lRequest.getdPayment()*100.0)/100.0));
					}
				else{
						txtMortgagePayment.setText("BUY A CHEAPER ONE");			
					}
		}
			
		else{
				if(lRequest.getdPayment() < PITI1){
				
			
				lblMortgagePayment.setText("The cost is: " + String.format("%1$,.2f", Math.round(lRequest.getdPayment()*100.0)/100.0));
				}
				else{
			
					txtMortgagePayment.setText("BUY A CHEAPER ONE");
				}

			}
	}
	private void initialize(){
		cmbTerm.setItems(cmbTermlist);
	}
}
