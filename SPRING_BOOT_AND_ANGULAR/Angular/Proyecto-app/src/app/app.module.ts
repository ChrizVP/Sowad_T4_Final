import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AuthGuard} from './auth.guard';

import { ListarClienteComponent } from './components/Cliente/listarCliente/listarCliente.component';
import { AddClienteComponent } from './components/Cliente/addCliente/addCliente.component';
import { EditClienteComponent } from './components/Cliente/editCliente/editCliente.component';

import { ListarPersonalComponent } from './components/Producto/listarPersonal/listarPersonal.component';
import { AddPersonalComponent } from './components/Producto/addPersonal/addPersonal.component';
import { EditPersonalComponent } from './components/Producto/editPersonal/editPersonal.component';

import {FormsModule}from'@angular/forms';
import {ClienteService}from './components/Cliente/Service/Cliente.service';
import {PersonalService}from './components/Producto/Service/Personal.service';
import { LoginService } from './components/Login/Service/login.service';
import {LoginAuthService} from './components/Login/Service/login-auth.service';
import {AdmindashboardService} from './components/admindashboard/Service/admindashboard.service';
import {SidebarService} from './components/Share/sidebar/service/sidebar.service';
import {TopbarService} from './components/Share/topbar/service/topbar.service';
import { CotizacionnewService } from 'src/app/components/cotizacion/serviciow/cotizacionnew.service';
import { ServicioService } from 'src/app/components/Servicio/Servicio/servicio.service';

import {HttpClientModule} from '@angular/common/http';
import { SidebarComponent } from './components/Share/sidebar/sidebar/sidebar.component';
import { TopbarComponent } from './components/Share/topbar/topbar/topbar.component';
import { FooterComponent } from './components/Share/footer/footer.component';
import { LogoutModalComponent } from './components/Share/logout-modal/logout-modal.component';
import { PageContentComponent } from './components/Share/page-content/page-content.component';



import { LoginComponent } from './components/Login/Login/login.component';
import { HomeComponent } from './components/Share/home/home.component';
import { SignupComponent } from './components/admindashboard/signup/signup/signup.component';
import { UserDashboardComponent } from './components/userdashboard/userdashboard.component';
import { AdminDashboardComponent } from './components/admindashboard/admindashboard/admindashboard.component';
import { CotizacionnewComponent } from './components/cotizacion/contizacionnew/cotizacionnew/cotizacionnew.component';
import { AddcotizacionComponent } from './components/cotizacion/addcotizacion/addcotizacion/addcotizacion.component';
import { ReportcotizacionComponent } from './components/cotizacion/reportcotizacion/reportcotizacion/reportcotizacion.component';
import { AddServicioComponent } from './components/Servicio/addServicio/addServicio.component';
import { EditServicioComponent } from './components/Servicio/editServicio/editServicio.component';
import { ListarServicioComponent } from './components/Servicio/listarServicio/listarServicio.component';





@NgModule({
  declarations: [
    AppComponent,
    ListarClienteComponent,
    AddClienteComponent,
    EditClienteComponent,
    ListarPersonalComponent,
    AddPersonalComponent,
    EditPersonalComponent,
    SidebarComponent,
    TopbarComponent,
    FooterComponent,
    LogoutModalComponent,
    PageContentComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    CotizacionnewComponent,
    AddcotizacionComponent,
    ReportcotizacionComponent,
    AddServicioComponent,
    EditServicioComponent,
    ListarServicioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ClienteService,PersonalService,LoginService, AuthGuard,LoginAuthService,AdmindashboardService,SidebarService,TopbarService,CotizacionnewService,ServicioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
