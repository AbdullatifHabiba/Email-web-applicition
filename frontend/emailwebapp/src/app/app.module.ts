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
import { NgForm } from '@angular/forms';
import {EditorModule} from 'primeng/editor';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';                  //api
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';

const routes:Routes=[
  {path:"Compose",component:ComposeComponent},
  {path:"inbox",component:InboxComponent},
  {path:"SentItems",component:SentItemsComponent},
  {path:"Trash",component:TrashComponent},
  {path:"Drafts",component:DraftsComponent},
  {path:"Star",component:StarredComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"header",component:HeaderComponent},



]
@NgModule({
  declarations: [
    AppComponent,
    InboxComponent,
    HeaderComponent,
    SearchComponent,
    ComposeComponent,
    SentItemsComponent,
    TrashComponent,DraftsComponent,StarredComponent,LoginComponent, RegisterComponent

   ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,EditorModule, NgbModule,HttpClientModule, ReactiveFormsModule,FormsModule

  ],
  providers: [ComponentscontrollerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
