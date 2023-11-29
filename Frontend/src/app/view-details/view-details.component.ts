import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DashboardService } from '../dashboard.service';
import { Product } from '../model/Product';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-view-details',
  templateUrl: './view-details.component.html',
  styleUrls: ['./view-details.component.css']
})
export class ViewDetailsComponent {
  productList:Array<Product>=[]
  id:any;
  userName:string="";
  endPoint: string = "";
  product:Product={
    productCode: "",
    brand: "",
    price: "",
    userName: "",
    date: "",
    imagelink: "",
    description: ""
  }
  registrationService: any;
  router: any;
  postalAPIUrl: string = 'https://api.postalpincode.in/pincode/';
  pincodeData: any = {};

  constructor(private http: HttpClient, private service:DashboardService,private route:ActivatedRoute){ }
  ngOnInit(): void{
    this.route.params.subscribe(params => this.getProductById(params['id']));
    // this.checkServiceability();
  }
  

  getProductById(productCode:any){
    this.service.getProductById(productCode).subscribe((data:Product)=>this.product = data);
  }

  logOutLogin() {

    if(confirm("Are you sure to Logout ?")) { 
      this.registrationService.logOut();
      // location.reload();
       this.router.navigate(['/home']);
   }
   
  }

  checkServiceability(){
    this.http.get(this.postalAPIUrl+this.endPoint).subscribe((resp:any) => {
      this.pincodeData["status"] = resp[0]["Status"];
      if(resp[0]["Status"]==="Success") { 
       this.pincodeData["data"] = resp["0"]["PostOffice"][0];
      } else {
        this.pincodeData["data"]  =  resp["0"]["Message"];
      }
      console.log("ResponseNew", this.pincodeData);
    });
  }

  
  expected_delivery(){
    // var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    // var d = new Date(dateString);
    let currentDate = new Date().getTime();
    let delivery_date = new Date(currentDate + 7*24*60*60*1000);
    alert("Expected delivery on or before :" + delivery_date.toLocaleDateString('en-us', {weekday:'long'})+" " +delivery_date.toLocaleDateString());
  }

}
