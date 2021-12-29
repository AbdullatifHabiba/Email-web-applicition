import { Cdatatoemail } from './Cdatatoemail';
import { SentItemsComponent } from './SentItems/SentItems.component';
import { Email } from './Email';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { map } from 'rxjs';
import { DraftsComponent } from './Drafts/Drafts.component';

@Injectable({
  providedIn: 'root'
})
export class ComponentscontrollerService {

constructor(    private httpclient: HttpClient
  ) { }

private urlserver='http://localhost:8080/folder/inbox';
  InboxEmails=[];
  draftEmails:any=[];

  result:any;
   sent?:SentItemsComponent;
   draft?:DraftsComponent;
   checklogin(username:string,password:string):Observable<boolean>{
     this.httpclient.get<boolean>('http://localhost:8080/operate/checklogin',{params:{
      username:username,
      password:password

    },observe: 'response'}).subscribe(
      (response) => {
        this.result = response.body;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    return this.result;
  }
  makelogin (form:any):Observable<boolean>{
    console.log(form)
    let f=JSON.stringify(form).toString();

     this.httpclient.get<boolean>('http://localhost:8080/operate/checkregister',{
       params:{Form:f},observe: 'response'}).subscribe(
        (response) => {
          this.result = response.body;
  //console.log(this.result)
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
      return this.result;

  }

  postemail(email:FormData){

    return this.httpclient.post('http://localhost:8080/operate/send',email).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );

  }

  setdraft(email:FormData){
    console.log(email)

    return this.httpclient.post('http://localhost:8080/operate/draft',email).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );

    }

 getemails(page:number,folder:string)
  {
    return this.httpclient.get('http://localhost:8080/operate/displayemails',{params:{
      Page:page,
      Type:folder

    },observe: 'response'});

  }


getemaildetails(id:number,type:string){
  return this.httpclient.get('http://localhost:8080/operate/displayemails',{params:{
      Position:id,
      Type:type

    },observe: 'response'})
}
delete(id:number,type:string){
  return this.httpclient.get('http://localhost:8080/operate/delete',{params:{
      Position:id,
      Type:type

    },observe: 'response'})
}
star(id:number,type:string){
  return this.httpclient.get('http://localhost:8080/operate/star',{params:{
      Position:id,
      Type:type

    },observe: 'response'})
}
Sort(type:string,emailstype:string){
  return this.httpclient.get('http://localhost:8080/operate/',{params:{
      Type:type,
      EmailsType:emailstype
    },observe: 'response'})
}



}
