import icon from '../../assets/imagens/notificationIcon.svg'
import './styles.css'
function NotificationButton() {
    return (
        <div className="dsmeta-red-btn">
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton
