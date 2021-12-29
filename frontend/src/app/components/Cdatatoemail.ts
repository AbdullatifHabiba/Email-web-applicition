import { Email } from './Email';
export class Cdatatoemail {
 email:Email
  constructor( private dataform:FormData){
this.email=new Email();

  }
  convert():Email{
let data=JSON.parse (JSON.stringify(this.dataform.get('Info')));
this.email.Subject=data.get('subject')
this.email.to=data.get('to')
this.email.from=data.get('from')
this.email.body=data.get('body')

return this.email;
  }

}
