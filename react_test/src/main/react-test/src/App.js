import logo from './logo.svg';
import './App.css';
import { useState, useEffect } from 'react';
import axios from 'axios';



function App() {
  const [hello, setHello] = useState('');
  const [menuList, setMenuList] = useState([]);
  
	useEffect(()=>{
		axios.get('/api/test')
			.then(result => {
				console.log(result);
				setHello(result.data);
			})
			.catch(()=>{
				
			})
			.finally(()=>{
				
			})
	})
  
  
    return (
  
	  <div className="App">
		<h3>서버에서 들어온 값 : {hello}</h3>
		<hr></hr>
		{
			menuList.map(menu=>{
				return(
					<div>
						{menu.name}
					</div>
				)
			})
		}
		<button onClick={()=>{
			axios.get('/api/menuall')
				.then(result=>{
					console.log(result);
					setMenuList(result.data);
					
				})
				.catch(()=>{
					console.log("실패");
				})
				
		}}>서버에서 메뉴 가져오기</button>		
				
		<button onClick={()=>{
			axios.post('/api/addmenu', {
			restaurant : '비욘더 강남',
			name : '딜허브',
			price : 22000,
			taste : 'MILD',
			type : 'KR'
			}
				)
			.then(result => {
				console.log(result);
		  })
		}}>메뉴 추가</button>
		
		
		
	 </div>
  );
}

export default App;
