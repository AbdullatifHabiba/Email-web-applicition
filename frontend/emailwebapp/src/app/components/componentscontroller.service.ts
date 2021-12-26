import { Email } from './Email';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComponentscontrollerService {

constructor(    private httpclient: HttpClient
  ) { }

private urlserver='http://localhost:8080/folder/inbox';
  InboxEmails:any=[];
  result:any;
  postemail(email:FormData){
    this.httpclient.post( 'http://localhost:8080/operate/post', email )
    .subscribe(( ) => {
    });  }
getinbox(page:number):Observable<Email[]>
  {
    return this.httpclient
      .get<Email[]>(this.urlserver+'?page=${page}').pipe(map(response=>response))
       /* params: { userid: userid },
        observe: 'response'
      })
      .subscribe(
        (response) => {
          this.result = response.body;

          this.InboxEmails = JSON.parse( this.result);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );*/
  }
checklogin(username:string,password:string){
  return this.httpclient.get<boolean>('http://localhost:8080/operate/logined',{params:{
    username:username,
    password:password

  }})
}
makelogin(form:any){
  console.log(form)

  return this.httpclient.post('http://localhost:8080/operate/login',form)
}
}
