import  { Link } from 'react-router-dom';
import styles from './MainNavigation.module.css'
import { NavLink } from "react-router-dom"

function MainNavigation() {
    return <header className={styles.header}>
        <nav>
            <h1>TestNav</h1>
        </nav>
    </header>


}
export default MainNavigation;