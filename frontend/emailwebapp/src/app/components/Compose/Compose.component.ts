import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EditorModule } from 'primeng/editor';
import { ComponentscontrollerService } from '../componentscontroller.service';

@Component({
  selector: 'app-Compose',
  templateUrl: './Compose.component.html',
  styleUrls: ['./Compose.component.css']
})
export class ComposeComponent implements OnInit {

  constructor(private formB:FormBuilder,private controller:ComponentscontrollerService) {
    this.form=this.formB.group({ form:this.formB.group({
      to:['',[Validators.required]],
      from:['',[Validators.required]],
      subject:['',],
      body:['',],
      file:[null]
    })})




      }
  default="Hello";
  ngOnInit() {
  }
  public formData = new FormData();

  form: FormGroup;
  ReqJson:any={};
sendemail(){
 let f= this.form.get(['form'])?.value
 console.log(f.to);
  this.ReqJson["to"] = f.to;
  this.ReqJson["from"] = f.from;
  this.ReqJson["subject"] = f.subject;
  this.ReqJson["body"] = f.body;
  this.formData.append( 'Info', JSON.stringify( this.ReqJson ) )
this.controller.postemail(this.formData);

}
uploadFile(e: any) {


  for ( let i = 0; i < e.length; i++ ) {
    this.formData.append( "file", e.files[i], e.files[i]['name'] );
}
  console.log(e.files);
}

}
