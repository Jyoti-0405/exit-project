import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { TokenInterceptorService } from './token-interceptor.service';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FilterPipe } from './filter.pipe';
import { NgxBootstrapIconsModule } from 'ngx-bootstrap-icons';
import { plusCircle,search,} from 'ngx-bootstrap-icons';
import { ShowAllQuestionsComponent } from './show-all-questions/show-all-questions.component';
import { ViewDetailsComponent } from './view-details/view-details.component';

const icons = {
  plusCircle,
  search
};
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    NavbarComponent,
    DashboardComponent,
    AddproductComponent,
    ProductlistComponent,
    FilterPipe,
    ShowAllQuestionsComponent,
    ViewDetailsComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    FontAwesomeModule,
    NgxBootstrapIconsModule.pick(icons)

       
  ],
  providers: [{provide:HTTP_INTERCEPTORS,useClass:TokenInterceptorService,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
