import { DraftsComponent } from './../Drafts/Drafts.component';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EditorModule } from 'primeng/editor';
import { ComponentscontrollerService } from '../componentscontroller.service';

@Component({
  selector: 'app-Compose',
  templateUrl: './Compose.component.html',
  styleUrls: ['./Compose.component.css']
})
export class ComposeComponent implements OnInit,OnDestroy {

  constructor(private formB:FormBuilder,private controller:ComponentscontrollerService) {
    this.form=this.formB.group({ form:this.formB.group({
      to:['',[Validators.required]],
      from:['',[Validators.required]],
      subject:['',],
      body:['',],
      importance:['',],
      file:[null]
    })})




      }
  default="Hello";
  ngOnInit() {
  }
  ngOnDestroy(): void {

  }
  public formData = new FormData();

  form: FormGroup;
  ReqJson:any={};
  file:any;
  draft(){
    let f= this.form.get(['form'])?.value
     this.ReqJson["To"] = f.to;
     this.ReqJson["From"] = f.from;
     this.ReqJson["Object"] = f.subject;
     this.ReqJson["Body"] = f.body;
     this.formData.append( 'Info', JSON.stringify( this.ReqJson ) )
this.controller.setdraft(this.formData);

  }
sendemail(){
  let date=new Date();
 let f= this.form.get(['form'])?.value
  this.ReqJson["To"] = f.to;
  this.ReqJson["From"] = f.from;
  this.ReqJson["Object"] = f.subject;
  this.ReqJson["Body"] = f.body;
  this.ReqJson["Importance"] = f.importance;
  this.ReqJson["Date"] = date;


  this.formData.append( 'Info', JSON.stringify( this.ReqJson ) )
  console.log(this.formData.get('Info'),this.formData.get('file'))
  console.log(this.controller.postemail(this.formData));
  

}
uploadFile(e: any) {



    this.formData.append( 'file', e.files[0] );

  console.log(e.files);
  console.log(this.formData.get('file'))

}

}
