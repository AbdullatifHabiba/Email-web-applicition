import { Cdatatoemail } from './Cdatatoemail';
import { SentItemsComponent } from './SentItems/SentItems.component';
import { Email } from './Email';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
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
   checklogin(username:string,password:string){
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
  makelogin (form:any){
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
    //).subscribe(
    //     (response) => {
    //       this.result = response;
    //      console.log(this.result)
    //     //this.sent?.Sentemails.push(this.result);
    //     },
    //     (error: HttpErrorResponse) => {
    //       alert(error.message);
    //     }
    //   );
  }
  setdraft(email:FormData){
    this.draftEmails.push(email);
    console.log(email)

    return this.httpclient.post('http://localhost:8080/operate/draft',email);

    }

 getinbox(page:number):Observable<Email[]>
  {
    return this.httpclient
      .get<Email[]>(this.urlserver+`?page+${page}`).pipe(map(response=>response))

  }


getemaildetails(id:number):Observable<Email>{
  return this.httpclient
    .get<Email>(this.urlserver + `?index=${id}`).pipe(map(response => response));
}


}
