import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListarClienteComponent } from './components/Cliente/listarCliente/listarCliente.component';
import { AddClienteComponent } from './components/Cliente/addCliente/addCliente.component';
import { EditClienteComponent } from './components/Cliente/editCliente/editCliente.component';

import { ListarPersonalComponent } from './components/Producto/listarPersonal/listarPersonal.component';
import { AddPersonalComponent } from './components/Producto/addPersonal/addPersonal.component';
import { EditPersonalComponent } from './components/Producto/editPersonal/editPersonal.component';

import { ListarServicioComponent } from './components/Servicio/listarServicio/listarServicio.component';
import { AddServicioComponent } from './components/Servicio/addServicio/addServicio.component';
import { EditServicioComponent } from './components/Servicio/editServicio/editServicio.component';

import { CotizacionnewComponent } from 'src/app/components/cotizacion/contizacionnew/cotizacionnew/cotizacionnew.component';
import { AddcotizacionComponent } from '../app/components/cotizacion/addcotizacion/addcotizacion/addcotizacion.component';
import { ReportcotizacionComponent } from '../app/components/cotizacion/reportcotizacion/reportcotizacion/reportcotizacion.component';


import { LoginComponent } from './components/Login/Login/login.component';
import { HomeComponent } from './components/Share/home/home.component';
import {AuthGuard} from'./auth.guard';
import { SignupComponent } from './components/admindashboard/signup/signup/signup.component';
import { AdminDashboardComponent } from './components/admindashboard/admindashboard/admindashboard.component';
import { UserDashboardComponent } from './components/userdashboard/userdashboard.component';


const routes: Routes = [

  {path:'listarCliente',component:ListarClienteComponent, canActivate:[AuthGuard]},
  {path:'addCliente',component:AddClienteComponent, canActivate:[AuthGuard]},
  {path:'editCliente',component:EditClienteComponent, canActivate:[AuthGuard]},
  
  {path:'listarPersonal',component:ListarPersonalComponent, canActivate:[AuthGuard]},
  {path:'addPersonal',component:AddPersonalComponent, canActivate:[AuthGuard]},
  {path:'editPersonal',component:EditPersonalComponent, canActivate:[AuthGuard]},
  {path:'login', component:LoginComponent},
  {path:'home', component:HomeComponent, canActivate:[AuthGuard]},
  {path: 'signup', component:SignupComponent, canActivate:[AuthGuard]},
  {path: 'admindashboard', component:AdminDashboardComponent, canActivate:[AuthGuard]},
  {path: 'userdashboard', component:UserDashboardComponent, canActivate:[AuthGuard]},
  {path: 'cotizacionnew', component:CotizacionnewComponent, canActivate:[AuthGuard]},
  {path: 'addcotizacion', component:AddcotizacionComponent, canActivate:[AuthGuard]},
  {path: 'reportcotizacion', component:ReportcotizacionComponent, canActivate:[AuthGuard]},

  {path: 'listarServicio', component:ListarServicioComponent, canActivate:[AuthGuard]},
  {path: 'addServicio', component:AddServicioComponent, canActivate:[AuthGuard]},
  {path: 'editServicio', component:EditServicioComponent, canActivate:[AuthGuard]},
  
  {path:'**',pathMatch:'full', redirectTo:'login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
