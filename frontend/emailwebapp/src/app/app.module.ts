import { LoginComponent } from './components/login/login.component';
import { ComponentscontrollerService } from './components/componentscontroller.service';
import { StarredComponent } from './components/Starred/Starred.component';
import { ComposeComponent } from './components/Compose/Compose.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InboxComponent } from './components/inbox/inbox.component';
import { HeaderComponent } from './components/header/header.component';
import { SearchComponent } from './components/search/search.component';
import { SentItemsComponent } from './components/SentItems/SentItems.component';
import { TrashComponent } from './components/Trash/Trash.component';
import { DraftsComponent } from './components/Drafts/Drafts.component';
import {  MatTableModule } from '@angular/material/table';
import {FileUploadModule} from 'primeng/fileupload';
import {MatPaginatorModule} from '@angular/material/paginator';
import {EditorModule} from 'primeng/editor';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';                  //api
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { EmailDetialsComponent } from './components/EmailDetials/EmailDetials.component';
import { ContactComponent } from './components/Contact/Contact.component';
import { ResolveService } from './components/EmailDetials/resolve.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const routes:Routes=[

  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},


  {path:'header/:user',component:HeaderComponent,
  children:[
    {path:'',component:InboxComponent },
  {path:'Compose',component:ComposeComponent},
  {path:'inbox',component:InboxComponent,children:[

    {path:':id',component:EmailDetialsComponent,resolve: {
      email: ResolveService
    }}

  ]
   },



  {path:"SentItems",component:SentItemsComponent,children:[

    {path:':id',component:EmailDetialsComponent,resolve: {
      email: ResolveService
    }}

  ]},
  {path:'contact',component:ContactComponent},
  {path:"Trash",component:TrashComponent,children:[

    {path:':id',component:EmailDetialsComponent,resolve: {
      email: ResolveService
    }}

  ]},
  {path:"Drafts",component:DraftsComponent,children:[

    {path:':id',component:EmailDetialsComponent,resolve: {
      email: ResolveService
    }}

  ]},
  {path:"Star",component:StarredComponent,children:[

    {path:':id',component:EmailDetialsComponent,resolve: {
      email: ResolveService
    }}

  ]},


    ]},




]
@NgModule({
  declarations: [
    AppComponent,
    InboxComponent,
    HeaderComponent,
    SearchComponent,
    ComposeComponent,
    SentItemsComponent,
    TrashComponent,DraftsComponent,StarredComponent,LoginComponent, RegisterComponent,EmailDetialsComponent,ContactComponent

   ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,MatTableModule,
    AppRoutingModule,EditorModule, FileUploadModule,NgbModule,HttpClientModule, ReactiveFormsModule,FormsModule, BrowserAnimationsModule,MatPaginatorModule,

  ],
  providers: [ComponentscontrollerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
